本系统为简单的B2C电商系统，类似于天猫商城。用户可以注册，登录，选择产品后进行购买产品。

**实现技术**
* 前端技术: HTML，CSS， JavaScript， jQuery， Bootstrap框架
* 编程语言: Java
* 后端技术: JSP， Sprig， SpringMVC， Mybatis
* 数据库： MySQL
* 项目构建管理：Maven
* 其他技术：Ajax， Web service

数据库表

用户表(user)
|      字段     |   说明  |   数据类型 |
|:-------------:|:------:|:---------:|
|     user_id   |  主键  |    int(11) |
| user_username | 用户名 |   varchar(255) |
| user_password | 用户密码 |  varchar(255) |
|   user_money  |  用户余额 |   decimal(10, 2) |

用户头像表(user_avatar)
|      字段     |   说明   |   数据类型 |
|:-------------:|:--------:|:--------:|
|    avatar_id  |  主键    |   int(11) |
|   avatar_uri  |  头像路径 | varchar(255) |
|   avatar_uid  |  关联用户主键 |  int(11) |

收货地址(user_address)
|      字段     |   说明   |  数据类型 |
|:-------------:|:-------:|:---------:|
|    address_id  |  主键    |   int(11) |
|  address_name  |  收货人姓名 | varchar(255) |
|  address_phone  |  收货人联系电话 | varchar(255) |
| address_content|  收货地址  |  varchar(255) |
|   address_uid  | 关联用户主键 |   int(11) |

商品(product)
|      字段     |   说明   |  数据类型 |
|:-------------:|:------:|:---------:|
|   product_id  |  主键  |     int(11) |
|  product_title |  商品标题 | varchar(255) |
|  product_info |  商品说明 | varchar(4095) |
|  product_price | 商品价格 |   decimal(10, 2) |
|  product_stock | 商品库存 |   int(11) |
|   product_img  | 商品主图片 | varchar(255) |

商品副图片(product_img)
|      字段     |   说明  |  数据类型 |
|:-------------:|:------:|:---------:|
|   img_id  |  主键  |   int(11) |
|  img_img2 |  商品副图片 | varchar(255) |
|  img_img3 |  商品副图片 | varchar(255) |
|  img_pid |  关联商品主键 |  int(11) |

评论表(product_comment)
|      字段     |   说明   |   数据类型 |
|:-------------:|:------:|:----------:|
|   comment_id  |  主键  |   int(11) |
|  comment_content | 评论内容 | varchar(255) |
| comment_date_time | 评论时间 | datetime |
|  comment_uid |  关联用户主键 |   int(11) |
|  comment_pid |  关联商品主键 |   int(11) |

订单表(user_order)
|      字段     |   说明   |   数据类型 |
|:-------------:|:--------:|:---------:|
|  order_id     |  主键  |  int(11) |
| order_number  |  商品数量 | int(11) |
| order_status |  订单状态 |   int(11) |
| order_date_time |  订单时间 |  datetime |
| order_pid    |    关联用户主键 | int(11) |
| order_uid    |  关联商品主键  | int(11) |

用户表(admin_user) 此表由管理员管理
|      字段     |   说明  |  数据类型 |
|:-------------:|:------:|:---------:|
|     user_id   |  主键  |  int(11)   |
| userr_username | 用户名 | varchar(255)  |
| user_password | 用户密码 | varchar(255)  |

