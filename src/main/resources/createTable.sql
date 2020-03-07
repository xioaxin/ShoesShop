#存放建表语句
create table customer
(
    customerId         int auto_increment comment '顾客编号'
        primary key,
    customerName       varchar(32) null comment '顾客姓名',
    customerSex        varchar(4)  null comment '顾客性别',
    customerBirthday   date        null comment '顾客出生日期',
    customerPhone      varchar(32) null comment '顾客电话号码',
    customerAddr       varchar(48) null comment '顾客信息注册地址',
    customerPostNumber varchar(12) null comment '顾客注册地址邮箱编号',
    customerEmail      varchar(32) null comment '顾客注册电子邮箱'
)
    comment '顾客信息表';

create table customerroles
(
    rolesID   int auto_increment comment '角色编号'
        primary key,
    rolesName varchar(32) null comment '顾客角色名称'
)
    comment '顾客角色类型表';

create table customer_roles
(
    customerID int null comment '顾客信息ID',
    rolesID    int null comment '角色信息编号',
    constraint customer_roles_ibfk_1
        foreign key (customerID) references customer (customerId),
    constraint customer_roles_ibfk_2
        foreign key (rolesID) references customerroles (rolesID)
)
    comment '顾客和角色关联表';

create index customerID
    on customer_roles (customerID);

create index rolesID
    on customer_roles (rolesID);

