<template>
    <div class="login_back">

        <div style="display: flex; justify-content: center; align-items: center; height: 100vh">
            <el-card style="width: 300px;padding: 80px 60px 150px;">

                <div style="display: flex;align-items: center;justify-content: center;padding-bottom: 50px;">
                    <div
                        style="font-size: 50px; color: white;background:linear-gradient(270deg, white, #17ead9, #6078ea, white); padding: 10px 100px;">
                        LOGIN</div>
                </div>

                <div style="padding: 20px;">
                    <el-form :rules="loginRules" :model="loginParam" ref="loginForm">
                        <el-form-item prop="username">
                            <el-input v-model="loginParam.username" placeholder="用户名" style="border: none;"></el-input>
                        </el-form-item>
                        <el-form-item prop="password">
                            <el-input type="password" v-model="loginParam.password" placeholder="密码 "
                                show-password></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="doLogin" style="width: 100%;">登录</el-button>
                        </el-form-item>
                    </el-form>
                </div>
            </el-card>
        </div>
    </div>
</template>


<script setup>
import { ref, reactive } from 'vue'
import { login, logout } from '@/api/login';
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'

const router = useRouter();

const loginParam = ref({});

const loginForm = ref(null);

const loginRules = {
    username: [
        { required: true, message: '请输入用户名', trigger: 'blur' }
    ],
    password: [
        { required: true, message: '请输入密码', trigger: 'blur' }
    ]
}

const doLogin = async () => {

    await loginForm.value.validate(async (valid) => {
        if (valid) {
            await doLoginAction();
        }
    })


}

const doLoginAction = async () => {

    const res = await login(loginParam.value);

    if (res.code == 200) {

        localStorage.setItem('token', res.data);

        router.push({ path: "/" });
    } else {
        ElMessage.error(res.msg);
    }


}








</script>


<style lang="scss" scoped>
.login_back {
    background: linear-gradient(90deg, #17ead9, #6078ea);
}
</style>