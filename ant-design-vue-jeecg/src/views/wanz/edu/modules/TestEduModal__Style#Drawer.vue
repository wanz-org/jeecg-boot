<template>
  <a-drawer
    :title="title"
    :width="width"
    placement="right"
    :closable="false"
    @close="close"
    :visible="visible">
  
    <a-spin :spinning="confirmLoading">
      <a-form :form="form">

        <a-form-item label="学校代码" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'scCode', validatorRules.scCode]" placeholder="请输入学校代码"></a-input>
        </a-form-item>
        <a-form-item label="学校名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'scName', validatorRules.scName]" placeholder="请输入学校名称"></a-input>
        </a-form-item>
        <a-form-item label="英文名称" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'scNameEn', validatorRules.scNameEn]" placeholder="请输入英文名称"></a-input>
        </a-form-item>
        <a-form-item label="联系电话" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'telphone', validatorRules.telphone]" placeholder="请输入联系电话"></a-input>
        </a-form-item>
        <a-form-item label="学校地址" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'addr', validatorRules.addr]" placeholder="请输入学校地址"></a-input>
        </a-form-item>
        <a-form-item label="建立日期" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <j-date placeholder="请选择建立日期" v-decorator="[ 'bulidDate', validatorRules.bulidDate]" :trigger-change="true" style="width: 100%"/>
        </a-form-item>
        <a-form-item label="主页地址" :labelCol="labelCol" :wrapperCol="wrapperCol">
          <a-input v-decorator="[ 'homePage', validatorRules.homePage]" placeholder="请输入主页地址"></a-input>
        </a-form-item>
        
      </a-form>
    </a-spin>
    <a-button type="primary" @click="handleOk">确定</a-button>
    <a-button type="primary" @click="handleCancel">取消</a-button>
  </a-drawer>
</template>

<script>

  import { httpAction } from '@/api/manage'
  import pick from 'lodash.pick'
  import JDate from '@/components/jeecg/JDate'  
  
  export default {
    name: "TestEduModal",
    components: { 
      JDate,
    },
    data () {
      return {
        form: this.$form.createForm(this),
        title:"操作",
        width:800,
        visible: false,
        model: {},
        labelCol: {
          xs: { span: 24 },
          sm: { span: 5 },
        },
        wrapperCol: {
          xs: { span: 24 },
          sm: { span: 16 },
        },

        confirmLoading: false,
        validatorRules:{
        scCode:{rules: [{ required: true, message: '请输入学校代码!' }]},
        scName:{rules: [{ required: true, message: '请输入学校名称!' }]},
        scNameEn:{rules: [{ required: true, message: '请输入英文名称!' }]},
        telphone:{rules: [{ required: true, message: '请输入联系电话!' }]},
        addr:{},
        bulidDate:{},
        homePage:{},
        },
        url: {
          add: "/edu/testEdu/add",
          edit: "/edu/testEdu/edit",
        }
     
      }
    },
    created () {
    },
    methods: {
      add () {
        this.edit({});
      },
      edit (record) {
        this.form.resetFields();
        this.model = Object.assign({}, record);
        this.visible = true;
        this.$nextTick(() => {
          this.form.setFieldsValue(pick(this.model,'scCode','scName','scNameEn','telphone','addr','bulidDate','homePage'))
        })
      },
      close () {
        this.$emit('close');
        this.visible = false;
      },
      handleOk () {
        const that = this;
        // 触发表单验证
        this.form.validateFields((err, values) => {
          if (!err) {
            that.confirmLoading = true;
            let httpurl = '';
            let method = '';
            if(!this.model.id){
              httpurl+=this.url.add;
              method = 'post';
            }else{
              httpurl+=this.url.edit;
               method = 'put';
            }
            let formData = Object.assign(this.model, values);
            console.log("表单提交数据",formData)
            httpAction(httpurl,formData,method).then((res)=>{
              if(res.success){
                that.$message.success(res.message);
                that.$emit('ok');
              }else{
                that.$message.warning(res.message);
              }
            }).finally(() => {
              that.confirmLoading = false;
              that.close();
            })
          }
         
        })
      },
      handleCancel () {
        this.close()
      },
      popupCallback(row){
        this.form.setFieldsValue(pick(row,'scCode','scName','scNameEn','telphone','addr','bulidDate','homePage'))
      }
      
    }
  }
</script>

<style lang="less" scoped>
/** Button按钮间距 */
  .ant-btn {
    margin-left: 30px;
    margin-bottom: 30px;
    float: right;
  }
</style>