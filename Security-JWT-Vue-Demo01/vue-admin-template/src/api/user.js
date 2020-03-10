import request from '@/utils/request'

export function login(data) {
  return request({
    url: '/user/login?username=admin&password=123456',
    method: 'post',
    data
  })
}

export function getInfo(token) {
  return request({
    url: '/user/info',
    method: 'get',
    // params: { Authentication: token }
  })
}

export function logout() {
  return request({
    url: '/user/logout',
    method: 'post'
  })
}
