# wedding-manager

#### 介绍
婚介后台管理系统

#### 软件架构
软件架构说明1


#### 安装教程

1.  xxxx
2.  xxxx
3.  xxxx

#### 使用说明

1.  xxxx
2.  xxxx
3.  流水号生成器
module_name:模块名称
module_code:模块编码
config_templet:当前模块 使用的序列号模板
max_serial:存放当前序列号的值
pre_max_num：预生成序列号存放到缓存的个数
is_auto_increment:是否自动增长模式，0：否  1：是

注意：目前序列号模板只支持字母，动态数字（0000 代表1-9999），和日期用${DATE}的组合形式
is_auto_increment配置为1 ，这时配置模板为CX000000生成的序列号为：CX1 ,CX2，CX3.....
配置为0，这时配置模板为CX0000000生成的序列号为：CX00000001,CX00000002，CX00000003

#### 参与贡献

1.  Fork 本仓库
2.  新建 Feat_xxx 分支
3.  提交代码
4.  新建 Pull Request



