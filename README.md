[TOC]
# 介绍 
 **webpic** 是一个用java编写的图床工具，它能帮助你快速上传你的图片到微博云图床，并自动返回Markdown格式链接到剪贴板。配置完成后，要获取一个可用于markdown的图片外链只需要暂时只windows测试通过,因为java是跨平台,理论上mac linux 系统都可以更改配置使用的：




. **方式一**： 右击电脑本地图片→点击`你的自定义上传菜单`→自动生成图片URL到剪切板中，任意地方`Ctrl+v`均可粘贴

. **方式二**：
截图并点击复制到剪贴板→按上传快捷键→自动生成图片URL到剪切板中，任意地方`Ctrl+v`均可粘贴

. **方式三**：
 右击网页中的图片→点击`复制图片`→按上传快捷键→任意地方`Ctrl+v`均可粘贴
# 为什么开源

>其实代码很简单,应用 大佬的[微博图床Java api](https://github.com/echisan/wbp4j)简单开发为在windows环境配置成为方便的上传图床的小工具,包括自定义水印,输出到粘贴板url格式


>安全问题也是开源的必要性,因为jar包留有后门可以把你的敏感信息这里就是微博账号密码发送到我的服务器等地址

>还有就是接受大佬们的代码审核提出宝贵意见,可以联系我邮箱lkshuihua_2014@163.com 也可以提issue
#  准备环境
配置jdk1.8及以上,对java不熟悉的可以参考  [快速搭建java环境](https://hfanss.com/2019/%E5%BF%AB%E9%80%9F%E6%90%AD%E5%BB%BAJava%E7%94%9F%E4%BA%A7%E7%8E%AF%E5%A2%83.html)


下载已经打包好的jar包,也可以clone我的代码自己打包


[百度云盘下载](https://pan.baidu.com/s/1rSQcSzMamK9VhaRPW4aV2Q ) 提取码：`cuti `

运行jar包格式 
```
/**
     *
     * @param1 文件全路径 %1%
     * @param2 微博账号
     * @param3 微博密码
     * @param4 输出到剪贴板url格式 1为url 0为markdown格式 
     * @param5 是否使用加文字水印,0为加 1为否
     * @param5 水印文字内容 不可缺省
     */
```
```  
java -jar C:\webpic-1.0-client.jar %1%  yourname password 1 1 com.github.lkshuihua
```








# windows如何使用
1.安装jdk1.8以上 参考 [快速搭建java环境](https://hfanss.com/2019/%E5%BF%AB%E9%80%9F%E6%90%AD%E5%BB%BAJava%E7%94%9F%E4%BA%A7%E7%8E%AF%E5%A2%83.html)

2.下载 打包好的jar包以及.bat文件 [百度云盘下载](https://pan.baidu.com/s/1rSQcSzMamK9VhaRPW4aV2Q ) 提取码：`cuti `

3.打开注册表编辑器
`WIN+R`调用运行库，输入`regedit`，会打开注册表编辑器


![](https://ws2.sinaimg.cn/large/007JVmUOgy1g2dmdn0jvwj30ms0e6t9h.jpg)

找到计算机`\HKEY_CLASSES_ROOT\*\shell`

![](https://ws3.sinaimg.cn/large/007JVmUOgy1g2dmhvbwppj30xi0jvmy1.jpg)

新建项上传微博图床，在此项下再次新建项command，并修改右侧默认值 `cmd.exe /K "C:\wenpic\webpic.bat "%1""`

![](https://ws1.sinaimg.cn/large/007JVmUOgy1g2dmkmkrvkj30wv0k7my4.jpg)


在C盘根目录建文件夹：webpic，复制刚才的webpic.bat webpic-1.0-client.jar 这两个文件到这 
`webpic.bat `文件内容修改成你的微博账号密码放在这,建议微博小号
```
java -jar C:\webpic\webpic-1.0-client.jar %1%  yourname yourpassword 0 0 com.github.lkshuihua
exit
```

接下来可以使用了

使用示意图

![](https://ws2.sinaimg.cn/large/007JVmUOgy1g2dmwtmf41j30ir0qqdhe.jpg)

![](https://ws3.sinaimg.cn/large/007JVmUOgy1g2dmyrxka4j30xd0homyq.jpg)


任意地方`Ctrl+v`均可粘贴

```
![](https://ws2.sinaimg.cn/large/007JVmUOgy1g2dn0c0juej30la0ctjs9.jpg)
```