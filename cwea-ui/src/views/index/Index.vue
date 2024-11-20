<template>

    <div class="index_back" v-loading="loading">
        <el-header>
            <el-menu class="menu" mode="horizontal">
                <el-menu-item index="1">首页</el-menu-item>

                <el-menu-item index="2" @click="doLogout">退出登录</el-menu-item>


            </el-menu>
        </el-header>

        <div class="content" >

            <div>
                <el-card>

                    <div>
                        <el-table :data="pageInfo.list"
                            :header-cell-style="{ textAlign: 'center', background: '#f5f7fa', color: '#606266', fontWeight: 'bold' }"
                            :cell-style="{ textAlign: 'center' }">
                            <el-table-column type="index" label="序号" width="100"></el-table-column>
                            <el-table-column prop="apiToken" label="签名" width="200"></el-table-column>
                            <el-table-column prop="apiTime" label="剩余次数" width="100">
                                <template #default="scope">
                                    <span style="color: green;" v-if="scope.row.apiTime > 10">{{ scope.row.apiTime
                                        }}</span>
                                    <span style="color: red;" v-if="scope.row.apiTime <= 10">{{ scope.row.apiTime
                                        }}</span>
                                    次
                                </template>
                            </el-table-column>
                            <el-table-column prop="expire" label="是否过期" width="100">
                                <template #default="scope">
                                    <el-switch v-model="scope.row.expire" active-color="#13ce66" inline-prompt
                                        @change="changeExpire(scope.row)" :active-value="1" :inactive-value="0"
                                        inactive-color="#ff4949" active-text="是" width="40"
                                        inactive-text="否"></el-switch>
                                </template>
                            </el-table-column>
                            <el-table-column prop="createTime" label="创建时间" width="180">
                                <template #default="scope">
                                    {{ dateFormat(scope.row.createTime) }}
                                </template>
                            </el-table-column>
                            <el-table-column prop="lastRequestTime" label="最后请求时间" width="180">
                                <template #default="scope">
                                    {{ dateFormat(scope.row.lastRequestTime) }}
                                </template>
                            </el-table-column>
                            <el-table-column prop="updateTime" label="操作" width="180">
                                <template #default="scope">
                                    <el-button text @click="openUpdateTime(scope.row)">修改次数</el-button>

                                    <el-popconfirm width="220" :icon="InfoFilled" icon-color="#626AEF" title="确定要删除吗？"
                                        @confirm="removeToken(scope.row)">
                                        <template #reference>
                                            <el-button text type="danger">删除</el-button>
                                        </template>
                                        <template #actions="{ confirm, cancel }">
                                            <el-button size="small" @click="cancel">否</el-button>
                                            <el-button type="danger" size="small" @click="confirm">
                                                是
                                            </el-button>
                                        </template>
                                    </el-popconfirm>

                                </template>
                            </el-table-column>
                        </el-table>
                    </div>

                    <div style="padding-top: 20px; display: flex; align-items: center; justify-content: space-between;">
                        <el-pagination @current-change="onCurrentChange" :current-page="queryParam.current"
                            :page-size="queryParam.pageSize" layout="total, prev, pager, next, jumper"
                            :total="pageInfo.total">
                        </el-pagination>

                        <div>
                            <el-button type="primary" @click="addOneToken">新增</el-button>
                            <el-button type="info" @click="loadPage">刷新</el-button>
                        </div>
                    </div>



                </el-card>


                <el-dialog title="修改次数" v-model="dialogVisible" width="30%">
                    <el-form :model="form" label-width="120px">
                        <el-form-item label="签名">
                            <el-input v-model="form.apiToken" disabled></el-input>
                        </el-form-item>
                        <el-form-item label="剩余次数">
                            <el-input-number v-model="form.apiTime" :min="0" :max="100000" />
                        </el-form-item>
                    </el-form>
                    <template #footer>
                        <span class="dialog-footer">
                            <el-button @click="dialogVisible = false">取 消</el-button>
                            <el-button type="primary" @click="updateApiTime">确 定</el-button>
                        </span>
                    </template>
                </el-dialog>

            </div>
        </div>
    </div>
</template>


<script setup>
import { getPage, updateTime, createToken, overdue, remove } from '@/api/index.js'
import { onMounted } from 'vue'
import { ref } from 'vue'
import { ElMessage } from 'element-plus';
import {InfoFilled} from '@element-plus/icons-vue';
import { format } from 'date-fns';
import { login, logout } from '@/api/login';

const pageInfo = ref({
    total: 0,
})
const dialogVisible = ref(false)
const form = ref({
    id: '',
    apiToken: '',
    apiTime: '',
})

const loading = ref(false);

// 修改次数
const openUpdateTime = (row) => {
    dialogVisible.value = true;
    form.value.id = row.id;
    form.value.apiToken = row.apiToken;
    form.value.apiTime = row.apiTime;
}

// 确认修改次数
const updateApiTime = async () => {
    const res = await updateTime(form.value)
    if (res.code == 200) {
        ElMessage.success('修改成功')
        dialogVisible.value = false;
        loadPage();
    } else {
        ElMessage.error('修改失败')
    }
}
 

const queryParam = ref({
    current: 1,
    pageSize: 10
})


const changeExpire = async (row) => {
    const res = await overdue({ id: row.id, expire: row.expire ? 1 : 0 })
    if (res.code == 200) {
        ElMessage.success('修改成功')
        loadPage();
    } else {
        ElMessage.error('修改失败')
    }
}

const removeToken = async (row) => {
    const res = await remove({ id: row.id })
    if (res.code == 200) {
        ElMessage.success('删除成功')
        loadPage();
    } else {
        ElMessage.error('删除失败')
    }
}


// 格式化时间
const dateFormat = (date) => {
    if (!date) {
        return '';
    }
    return format(date, 'yyyy-MM-dd');
}

// 加载分页数据
const loadPage = async () => {
    loading.value = true;
    const res = await getPage(queryParam.value)
    pageInfo.value = res.data;
    loading.value = false;
}

const addOneToken = async () => {

    const res = await createToken();
    if (res.code == 200) {
        ElMessage.success('添加成功')
        loadPage();
    } else {
        ElMessage.error('添加失败')
    }

    loadPage();
}

const doLogout = async () => {
    const res = await logout()
    if (res.code == 200) {
        ElMessage.success('退出成功')
        localStorage.removeItem('token')
        setTimeout(() => {
            window.location.href = '/login'
        }, 300);
    } else {
        ElMessage.error('退出失败')
    }
}

const onCurrentChange = (current) => {
    queryParam.value.current = current;
    loadPage();
}




onMounted(() => {
    loadPage();
})



</script>

<style lang="scss" scoped>
.index_back {
    height: 100%;
}

.content {
    // 居中
    display: flex;
    justify-content: center;
    align-items: flex-start;
    padding-top: 5%;
}

.menu {
    display: flex;
    justify-content: space-between;
    /* 将菜单项分散 */
}

.menu-right {
    margin-left: auto;
    /* 将右侧菜单项推到最右 */
}
</style>