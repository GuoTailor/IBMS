(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["chunk-73079c02"],{2017:function(e,s,t){"use strict";t("cafe")},"93d4":function(e,s,t){},"9ed6":function(e,s,t){"use strict";t.r(s);var o=function(){var e=this,s=e.$createElement,t=e._self._c||s;return t("div",{staticClass:"login-container"},[t("el-form",{ref:"loginForm",staticClass:"login-form",attrs:{model:e.loginForm,rules:e.loginRules,"auto-complete":"on","label-position":"left"}},[t("div",{staticClass:"title-container"},[t("h3",{staticClass:"title"},[e._v("登录IBMS管理系统")])]),t("el-form-item",{attrs:{prop:"username"}},[t("span",{staticClass:"svg-container"},[t("svg-icon",{attrs:{"icon-class":"user"}})],1),t("el-input",{ref:"username",attrs:{placeholder:"请输入用户名",name:"username",type:"text",tabindex:"1","auto-complete":"on"},model:{value:e.loginForm.username,callback:function(s){e.$set(e.loginForm,"username",s)},expression:"loginForm.username"}})],1),t("el-form-item",{attrs:{prop:"password"}},[t("span",{staticClass:"svg-container"},[t("svg-icon",{attrs:{"icon-class":"password"}})],1),t("el-input",{key:e.passwordType,ref:"password",attrs:{type:e.passwordType,placeholder:"请输入密码",name:"password",tabindex:"2","auto-complete":"on"},nativeOn:{keyup:function(s){return!s.type.indexOf("key")&&e._k(s.keyCode,"enter",13,s.key,"Enter")?null:e.handleLogin(s)}},model:{value:e.loginForm.password,callback:function(s){e.$set(e.loginForm,"password",s)},expression:"loginForm.password"}}),t("span",{staticClass:"show-pwd",on:{click:e.showPwd}},[t("svg-icon",{attrs:{"icon-class":"password"===e.passwordType?"eye":"eye-open"}})],1)],1),t("div",{staticClass:"checked-box"},[t("el-checkbox",{model:{value:e.checked,callback:function(s){e.checked=s},expression:"checked"}},[e._v("记住登录")])],1),t("el-button",{staticStyle:{width:"100%","margin-bottom":"30px"},attrs:{loading:e.loading,type:"primary"},nativeOn:{click:function(s){return s.preventDefault(),e.handleLogin(s)}}},[e._v("Login")])],1)],1)},n=[],r=t("5f87"),a={name:"Login",data:function(){var e=function(e,s,t){s?t():t(new Error("请输入用户名"))},s=Object(r["c"])(),t=Object(r["a"])();return{loginForm:{username:s,password:t},loginRules:{username:[{required:!0,trigger:"blur",validator:e}],password:[{required:!0,trigger:"blur",message:"密码不能为空"}]},loading:!1,checked:!0,passwordType:"password",redirect:void 0}},watch:{$route:{handler:function(e){this.redirect=e.query&&e.query.redirect},immediate:!0}},methods:{showPwd:function(){var e=this;"password"===this.passwordType?this.passwordType="":this.passwordType="password",this.$nextTick((function(){e.$refs.password.focus()}))},handleLogin:function(){var e=this;this.$refs.loginForm.validate((function(s){if(!s)return console.log("error submit!!"),!1;e.loading=!0;var t=e.checked;e.$store.dispatch("user/login",e.loginForm).then((function(){t?(Object(r["i"])(e.loginForm.username),Object(r["g"])(e.loginForm.password)):(Object(r["f"])(),Object(r["d"])()),e.$router.push({path:"/"}),e.loading=!1})).catch((function(){e.loading=!1}))}))}}},i=a,c=(t("2017"),t("e630"),t("2877")),l=Object(c["a"])(i,o,n,!1,null,"38c5eec8",null);s["default"]=l.exports},cafe:function(e,s,t){},e630:function(e,s,t){"use strict";t("93d4")}}]);