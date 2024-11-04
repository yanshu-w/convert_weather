import request from "@/utils/requtst";



export function login(data) {
    return request({
        url: "/sysUser/doLogin",
        method: "post",
        data
    })
}

export function logout() {
    return request({
        url: "/sysUser/logout",
        method: "post"
    })
}




