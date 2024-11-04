import request from "@/utils/requtst";



export function createToken() {
    return request({
        url: "/apiConfig/createToken",
        method: "post"
    })
}

export function overdue(data) {
    return request({
        url: "/apiConfig/overdue",
        method: "post",
        data
    })
}

export function updateTime(data) {
    return request({
        url: "/apiConfig/updateTime",
        method: "post",
        data
    })
}

export function getPage(data) {
    return request({
        url: "/apiConfig/getPage",
        method: "post",
        data
    })
}




