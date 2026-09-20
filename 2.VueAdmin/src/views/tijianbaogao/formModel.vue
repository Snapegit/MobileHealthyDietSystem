<template>
	<div>
		<el-dialog v-model="formVisible" :title="formTitle" width="80%" destroy-on-close :fullscreen='false'>
			<el-form class="formModel_form" ref="formRef" :model="form" label-width="$template2.back.add.form.base.labelWidth" :rules="rules">
				<el-row>
					<el-col :span="24">
						<el-form-item label="体检日期" prop="tijianriqi">
							<el-date-picker
								class="list_date"
								v-model="form.tijianriqi"
								format="YYYY 年 MM 月 DD 日"
								value-format="YYYY-MM-DD"
								type="datetime"
								:readonly="!isAdd||disabledForm.tijianriqi?true:false"
								placeholder="请选择体检日期" />
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="主要病史" prop="zhuyaobingshi">
							<el-input class="list_inp" v-model="form.zhuyaobingshi" placeholder="主要病史"
								 type="text" 								:readonly="!isAdd||disabledForm.zhuyaobingshi?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="身高/cm" prop="shengao">
							<el-input class="list_inp" v-model="form.shengao" placeholder="身高/cm"
								 type="text" 								:readonly="!isAdd||disabledForm.shengao?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="体重/kg" prop="tizhong">
							<el-input class="list_inp" v-model="form.tizhong" placeholder="体重/kg"
								 type="text" 								:readonly="!isAdd||disabledForm.tizhong?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="检查项目" prop="jianchaxiangmu">
							<el-input class="list_inp" v-model="form.jianchaxiangmu" placeholder="检查项目"
								 type="text" 								:readonly="!isAdd||disabledForm.jianchaxiangmu?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="检查结果" prop="jianchajieguo">
							<uploads
								:disabled="!isAdd||disabledForm.jianchajieguo?true:false"
								type="file"
								action="file/upload" 
								tip="请上传检查结果" 
								:limit="1" 
								style="width: 100%;text-align: left;"
								:fileUrls="form.jianchajieguo?form.jianchajieguo:''" 
								@change="jianchajieguoUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="检查意见" prop="jianchayijian">
							<el-input class="list_inp" v-model="form.jianchayijian" placeholder="检查意见"
								 type="text" 								:readonly="!isAdd||disabledForm.jianchayijian?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="备注" prop="beizhu">
							<el-input class="list_inp" v-model="form.beizhu" placeholder="备注"
								 type="text" 								:readonly="!isAdd||disabledForm.beizhu?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="附件" prop="fujian">
							<uploads
								:disabled="!isAdd||disabledForm.fujian?true:false"
								type="file"
								action="file/upload" 
								tip="请上传附件" 
								:limit="1" 
								style="width: 100%;text-align: left;"
								:fileUrls="form.fujian?form.fujian:''" 
								@change="fujianUploadSuccess">
							</uploads>
						</el-form-item>
					</el-col>
					<el-col :span="24">
						<el-form-item label="用户账号" prop="yonghuzhanghao">
							<el-input class="list_inp" v-model="form.yonghuzhanghao" placeholder="用户账号"
								 type="text" 								:readonly="!isAdd||disabledForm.yonghuzhanghao?true:false" />
						</el-form-item>
					</el-col>

					<el-col :span="24">
						<el-form-item label="用户姓名" prop="yonghuxingming">
							<el-input class="list_inp" v-model="form.yonghuxingming" placeholder="用户姓名"
								 type="text" 								:readonly="!isAdd||disabledForm.yonghuxingming?true:false" />
						</el-form-item>
					</el-col>

				</el-row>
			</el-form>
			<template #footer v-if="isAdd||type=='logistics'||type=='reply'">
				<span class="formModel_btn_box">
					<el-button class="formModel_cancel" @click="closeClick">取消</el-button>
					<el-button class="formModel_confirm" type="primary" @click="save"
						>
						提交
					</el-button>
				</span>
			</template>
		</el-dialog>
	</div>
</template>
<script setup>
	import {
		reactive,
		ref,
		getCurrentInstance,
		nextTick,
		computed,
		defineEmits
	} from 'vue'
	const context = getCurrentInstance()?.appContext.config.globalProperties;	
	const emit = defineEmits(['formModelChange'])
	//基础信息
	const tableName = 'tijianbaogao'
	const formName = '体检报告'
	//基础信息
	//form表单
	const form = ref({})
	const disabledForm = ref({
		tijianriqi : false,
		zhuyaobingshi : false,
		shengao : false,
		tizhong : false,
		jianchaxiangmu : false,
		jianchajieguo : false,
		jianchayijian : false,
		beizhu : false,
		fujian : false,
		yonghuzhanghao : false,
		yonghuxingming : false,
		sfsh : false,
		shhf : false,
	})
	const formVisible = ref(false)
	const isAdd = ref(false)
	const formTitle = ref('')
	//表单验证
	//匹配整数
	const validateIntNumber = (rule, value, callback) => {
		if (!value) {
			callback();
		} else if (!context?.$toolUtil.isIntNumer(value)) {
			callback(new Error("请输入整数"));
		} else {
			callback();
		}
	}
	//匹配数字
	const validateNumber = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isNumber(value)) {
			callback(new Error("请输入数字"));
		} else {
			callback();
		}
	}
	//匹配手机号码
	const validateMobile = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isMobile(value)) {
			callback(new Error("请输入正确的手机号码"));
		} else {
			callback();
		}
	}
	//匹配电话号码
	const validatePhone = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isPhone(value)) {
			callback(new Error("请输入正确的电话号码"));
		} else {
			callback();
		}
	}
	//匹配邮箱
	const validateEmail = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isEmail(value)) {
			callback(new Error("请输入正确的邮箱地址"));
		} else {
			callback();
		}
	}
	//匹配身份证
	const validateIdCard = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.checkIdCard(value)) {
			callback(new Error("请输入正确的身份证号码"));
		} else {
			callback();
		}
	}
	//匹配网站地址
	const validateUrl = (rule, value, callback) => {
		if(!value){
			callback();
		} else if (!context?.$toolUtil.isURL(value)) {
			callback(new Error("请输入正确的URL地址"));
		} else {
			callback();
		}
	}
	const rules = ref({
		tijianriqi: [
		],
		zhuyaobingshi: [
		],
		shengao: [
		],
		tizhong: [
		],
		jianchaxiangmu: [
		],
		jianchajieguo: [
		],
		jianchayijian: [
		],
		beizhu: [
		],
		fujian: [
		],
		yonghuzhanghao: [
		],
		yonghuxingming: [
		],
		sfsh: [
		],
		shhf: [
		],
	})
	//表单验证
	
	const formRef = ref(null)
	const id = ref(0)
	const type = ref('')
	//检查结果上传回调
	const jianchajieguoUploadSuccess=(e)=>{
		form.value.jianchajieguo = e
	}
	//附件上传回调
	const fujianUploadSuccess=(e)=>{
		form.value.fujian = e
	}
	//methods

	//获取唯一标识
	const getUUID =()=> {
      return new Date().getTime();
    }
	//重置
	const resetForm = () => {
		form.value = {
			tijianriqi: '',
			zhuyaobingshi: '',
			shengao: '',
			tizhong: '',
			jianchaxiangmu: '',
			jianchajieguo: '',
			jianchayijian: '',
			beizhu: '',
			fujian: '',
			yonghuzhanghao: '',
			yonghuxingming: '',
			sfsh: '待审核',
			shhf: '',
		}
	}
	//获取info
	const getInfo = ()=>{
		context?.$http({
			url: `${tableName}/info/${id.value}`,
			method: 'get'
		}).then(res => {
			let reg=new RegExp('../../../file','g')
			form.value = res.data.data
			formVisible.value = true
		})
	}
	const crossRow = ref('')
	const crossTable = ref('')
	const crossTips = ref('')
	const crossColumnName = ref('')
	const crossColumnValue = ref('')
	//初始化
	const init=(formId=null,formType='add',formNames='',row=null,table=null,statusColumnName=null,tips=null,statusColumnValue=null)=>{
		resetForm()
		if(formId){
			id.value = formId
			type.value = formType
		}
		if(formType == 'add'){
			isAdd.value = true
			formTitle.value = '新增' + formName
			formVisible.value = true
		}else if(formType == 'info'){
			isAdd.value = false
			formTitle.value = '查看' + formName
			getInfo()
		}else if(formType == 'edit'){
			isAdd.value = true
			formTitle.value = '修改' + formName
			getInfo()
		}
		else if(formType == 'cross'){
			isAdd.value = true
			formTitle.value = formNames
			// getInfo()
			for(let x in row){
				if(x=='tijianriqi'){
					form.value.tijianriqi = row[x];
					disabledForm.value.tijianriqi = true;
					continue;
				}
				if(x=='zhuyaobingshi'){
					form.value.zhuyaobingshi = row[x];
					disabledForm.value.zhuyaobingshi = true;
					continue;
				}
				if(x=='shengao'){
					form.value.shengao = row[x];
					disabledForm.value.shengao = true;
					continue;
				}
				if(x=='tizhong'){
					form.value.tizhong = row[x];
					disabledForm.value.tizhong = true;
					continue;
				}
				if(x=='jianchaxiangmu'){
					form.value.jianchaxiangmu = row[x];
					disabledForm.value.jianchaxiangmu = true;
					continue;
				}
				if(x=='jianchajieguo'){
					form.value.jianchajieguo = row[x];
					disabledForm.value.jianchajieguo = true;
					continue;
				}
				if(x=='jianchayijian'){
					form.value.jianchayijian = row[x];
					disabledForm.value.jianchayijian = true;
					continue;
				}
				if(x=='beizhu'){
					form.value.beizhu = row[x];
					disabledForm.value.beizhu = true;
					continue;
				}
				if(x=='fujian'){
					form.value.fujian = row[x];
					disabledForm.value.fujian = true;
					continue;
				}
				if(x=='yonghuzhanghao'){
					form.value.yonghuzhanghao = row[x];
					disabledForm.value.yonghuzhanghao = true;
					continue;
				}
				if(x=='yonghuxingming'){
					form.value.yonghuxingming = row[x];
					disabledForm.value.yonghuxingming = true;
					continue;
				}
			}
			if(row){
				crossRow.value = row
			}
			if(table){
				crossTable.value = table
			}
			if(tips){
				crossTips.value = tips
			}
			if(statusColumnName){
				crossColumnName.value = statusColumnName
			}
			if(statusColumnValue){
				crossColumnValue.value = statusColumnValue
			}
			form.value.sfsh='待审核'
			formVisible.value = true
		}

		context?.$http({
			url: `${context?.$toolUtil.storageGet('sessionTable')}/session`,
			method: 'get'
		}).then(res => {
			var json = res.data.data
			if(json.hasOwnProperty('yonghuzhanghao')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.yonghuzhanghao = json.yonghuzhanghao
				disabledForm.value.yonghuzhanghao = true;
			}
			if(json.hasOwnProperty('yonghuxingming')&& context?.$toolUtil.storageGet("role")!="管理员"){
				form.value.yonghuxingming = json.yonghuxingming
				disabledForm.value.yonghuxingming = true;
			}
		})
	}
	//初始化
	//声明父级调用
	defineExpose({
		init
	})
	//关闭
	const closeClick = () => {
		formVisible.value = false
	}
	//富文本
	const editorChange = (e,name) =>{
		form.value[name] = e
	}
	//提交
	const save=()=>{
		if(form.value.jianchajieguo!=null) {
			form.value.jianchajieguo = form.value.jianchajieguo.replace(new RegExp(context?.$config.url,"g"),"");
		}
		if(form.value.fujian!=null) {
			form.value.fujian = form.value.fujian.replace(new RegExp(context?.$config.url,"g"),"");
		}
		var table = crossTable.value
		var objcross = JSON.parse(JSON.stringify(crossRow.value))
		let crossUserId = ''
		let crossRefId = ''
		let crossOptNum = ''
		if(type.value == 'cross'){
			if(crossColumnName.value!=''){
				if(!crossColumnName.value.startsWith('[')){
					for(let o in objcross){
						if(o == crossColumnName.value){
							objcross[o] = crossColumnValue.value
						}
					}
					//修改跨表数据
					changeCrossData(objcross)
				}else{
					crossUserId = context?.$toolUtil.storageGet('userid')
					crossRefId = objcross['id']
					crossOptNum = crossColumnName.value.replace(/\[/,"").replace(/\]/,"")
				}
			}
		}
		formRef.value.validate((valid)=>{
			if(valid){
				if(crossUserId&&crossRefId){
					form.value.crossuserid = crossUserId
					form.value.crossrefid = crossRefId
					let params = {
						page: 1,
						limit: 1000, 
						crossuserid:form.value.crossuserid,
						crossrefid:form.value.crossrefid,
					}
					context?.$http({
						url: `${tableName}/page`,
						method: 'get', 
						params: params 
					}).then(res=>{
						if(res.data.data.total>=crossOptNum){
							context?.$toolUtil.message(`${crossTips.value}`,'error')
							return false
						}else{
							context?.$http({
								url: `${tableName}/${!form.value.id ? "save" : "update"}`,
								method: 'post', 
								data: form.value 
							}).then(res=>{
								context?.$toolUtil.message(`操作成功`,'success',()=>{
									formVisible.value = false
									emit('formModelChange')
								})
							})
						}
					})
				}else{
					context?.$http({
						url: `${tableName}/${!form.value.id ? "save" : "update"}`,
						method: 'post', 
						data: form.value 
					}).then(res=>{
						context?.$toolUtil.message(`操作成功`,'success',()=>{
							formVisible.value = false
							emit('formModelChange')
						})
					})
				}
			}
		})
	}
	//修改跨表数据
	const changeCrossData=(row)=>{
		context?.$http({
			url: `${crossTable.value}/update`,
			method: 'post',
			data: row
		}).then(res=>{})
	}
</script>
<style lang="scss" scoped>
	// 表单
	.formModel_form{
		border: 1px solid #ddd;
		border-radius: 4px;
		padding: 30px;
		margin: 0;
		background: #fff;
		// form item
		:deep(.el-form-item) {
			margin: 0 0 20px 0;
			display: flex;
			//label
			.el-form-item__label {
			 background: none;
			 display: block;
			 width: 150px;
			 min-width: 150px;
			 text-align: right;
			}
			// 内容盒子
			.el-form-item__content {
				display: flex;
				width: calc(100% - 120px);
				justify-content: flex-start;
				align-items: center;
				flex-wrap: wrap;
				// 输入框
				.list_inp {
					border: 1px solid #ddd;
					border-radius: 4px;
					padding: 0 10px;
					width: auto;
					line-height: 36px;
					box-sizing: border-box;
					min-width: 350px;
					height: 36px;
					//去掉默认样式
					.el-input__wrapper{
						border: none;
						box-shadow: none;
						background: none;
						border-radius: 0;
						height: 100%;
						padding: 0;
					}
					.is-focus {
						box-shadow: none !important;
					}
				}
				//日期选择器
				.list_date {
					border: 1px solid #ddd;
					border-radius: 4px;
					width: auto;
					line-height: 36px;
					box-sizing: border-box;
					min-width: 350px;
					//去掉默认样式
					.el-input__wrapper{
						border: none;
						box-shadow: none;
						background: none;
						border-radius: 0;
						height: 100%;
					}
				}
				//文件上传样式
				.upload-demo {
					width: 100%;
					//外部盒子
					.el-upload-dragger {
						border: 1px solid #ddd;
						cursor: pointer;
						background-color: #fff;
						border-radius: 4px;
						overflow: hidden;
						width: 360px;
						box-sizing: border-box;
						text-align: center;
						height: auto;
					}
					//图标
					.el-icon--upload {
						margin: 0;
						color: #D09D7D;
						font-size: 48px;
						line-height: 48px;
					}
					//提示文字
					.el-upload__text {
						margin: 0px 0 0;
						color: #9E9E9E;
						font-size: 14px;
						em {
							color: #D09D7D;
						}
					}
					//提示文字
					.el-upload__tip {
						margin: 0px 0 0;
						color: #9E9E9E;
						font-size: 14px;
					}
				}
			}
		}
	}
	// 按钮盒子
	.formModel_btn_box {
		display: flex;
		width: 100%;
		justify-content: center;
		align-items: center;
		.formModel_cancel {
			border: 0;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 24px;
			margin: 0 20px 0 0;
			outline: none;
			color: #313131;
			background: #EED7B3;
			width: auto;
			font-size: 14px;
			min-width: 100px;
			height: 36px;
		}
		.formModel_cancel:hover {
			color: #fff;
			background: #D09D7D;
		}
		
		.formModel_confirm {
			border: 0;
			cursor: pointer;
			border-radius: 4px;
			padding: 0 24px;
			margin: 0 20px 0 0;
			outline: none;
			color: #313131;
			background: #EED7B3;
			width: auto;
			font-size: 14px;
			min-width: 100px;
			height: 36px;
		}
		.formModel_confirm:hover {
			color: #fff;
			background: #D09D7D;
		}
	}
</style>