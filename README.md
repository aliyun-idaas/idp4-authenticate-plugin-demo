# idp4-authenticate-plugin-demo
认证源插件实现demo

开源协议：[GPL-3.0 License](https://github.com/aliyun-idaas/idp4-application-plugin-v2-demo/blob/main/LICENSE) 。

## 开发环境要求
- Java  v1.8+
- Maven 3.3+
- 字符编码：UTF-8

## 使用框架与版本
- com.idsmanager.idp.auth-core v4.16.0-mysql
- junit 4.12

> com.idsmanager.idp.auth-core不对外提供,如需要,请联系项目经理单独提供

## 如何使用
> 前提：需要有部署IDaas的实例。
1. clone工程到本地开发环境（需要安装Maven, JDK）。
2. maven打包: `mvn clean package`
3. 在IDaas中以IT管理员登录，在`其他管理`-`插件管理`-`认证源插件`,上传生成的jar文件:`target\auth-plugin-demo-1.1-jar-with-plugin.jar`
4. 在`认证`-`认证源`-`添加认证源` 找到`Demo`认证源,点击添加认证源即可

## 更多帮助
若需要更多帮助，可访问部署的IDaas实例的开发者文档中的'认证源插件'内容。