import request from "../axios/index";

const allData = data => request({ url: '/foodtruck/all', method: 'GET', data: data });
const searchFood = data => request({ url: '/foodtruck/search', method: 'POST', data: data });

export {
    allData,
    searchFood
}