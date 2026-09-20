	import {
		createRouter,
		createWebHashHistory
	} from 'vue-router'
	import jiankangzhishi from '@/views/jiankangzhishi/list'
	import yinshijianyi from '@/views/yinshijianyi/list'
	import binglidan from '@/views/binglidan/list'
	import yonghu from '@/views/yonghu/list'
	import jiankangshuju from '@/views/jiankangshuju/list'
	import jiankangshipu from '@/views/jiankangshipu/list'
	import messages from '@/views/messages/list'
	import storeup from '@/views/storeup/list'
	import config from '@/views/config/list'
	import tijianbaogao from '@/views/tijianbaogao/list'
	import jiankangjihua from '@/views/jiankangjihua/list'
	import users from '@/views/users/list'

export const routes = [{
		path: '/login',
		name: 'login',
		component: () => import('../views/login.vue')
	},{
		path: '/',
		name: '首页',
		component: () => import('../views/index'),
		children: [{
			path: '/',
			name: '首页',
			component: () => import('../views/HomeView.vue'),
			meta: {
				affix: true
			}
		}, {
			path: '/updatepassword',
			name: '修改密码',
			component: () => import('../views/updatepassword.vue')
		}
		
		,{
			path: '/jiankangzhishi',
			name: '健康知识',
			component: jiankangzhishi
		}
		,{
			path: '/yinshijianyi',
			name: '饮食建议',
			component: yinshijianyi
		}
		,{
			path: '/binglidan',
			name: '病例单',
			component: binglidan
		}
		,{
			path: '/yonghu',
			name: '用户',
			component: yonghu
		}
		,{
			path: '/jiankangshuju',
			name: '健康数据',
			component: jiankangshuju
		}
		,{
			path: '/jiankangshipu',
			name: '健康食谱',
			component: jiankangshipu
		}
		,{
			path: '/messages',
			name: '留言板',
			component: messages
		}
		,{
			path: '/storeup',
			name: '我的收藏',
			component: storeup
		}
		,{
			path: '/config',
			name: '轮播图',
			component: config
		}
		,{
			path: '/tijianbaogao',
			name: '体检报告',
			component: tijianbaogao
		}
		,{
			path: '/jiankangjihua',
			name: '健康计划',
			component: jiankangjihua
		}
		,{
			path: '/users',
			name: '管理员',
			component: users
		}
		]
	},
]

const router = createRouter({
	history: createWebHashHistory(process.env.BASE_URL),
	routes
})

export default router
