import axios from 'axios';

const serviceObj = {
    baseURL: '/api',
    timeout: 100 // 请求超时时间
}

const service = axios.create(serviceObj)

service.interceptors.request.use(
    config => {
        config.headers = {
            "Content-Type": "application/json",
        };
        return config;
    },
    error => {
        return Promise.reject(error)
    }
);

service.interceptors.response.use(
    res => {
        return res.data;
    },
    error => {
        return Promise.reject(error)
    }
);

export default ({url, method, data}) => {
    let config = {
        url: url,
        method: method || 'POST'
    }
    if (method === "GET") {
        config.params = data;
    }
    if (method === "POST") {
        config.data = data;
    }
    return new Promise((resolve, reject) => {
        service(config).then(res => {
            resolve(res);
        }).catch(err => {
            reject(err);
        })
    });
}
