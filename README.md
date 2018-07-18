# 佩奇餐饮管理系统

[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com)
[![forthebadge](https://forthebadge.com/images/badges/made-with-javascript.svg)](https://forthebadge.com)
- - - -
## 背景
实现餐厅的餐桌订单信息化，完成以下事件，达到提高效率的目的。
- - - -
* 显示预约
* 零散预约
* 新建预约
* 记录到达
* 修改预约信息
* 取消预约

## 实现
#### 软件类型：B/S结构的餐桌管理系统
#### 实现功能：
* 新建预约
* 显示餐桌信息
* 显示预约信息
* 记录到达
* 订单结束
* 取消预约
* 修改预约

#### 实现流程：
* **功能分析**：对需求进行系统的分析。
* **数据库设计**：按照类图设计好数据库，以及各种约束条件
* **界面设计**：采用H-ui的前端框架
* **编码实现**：采用Jsp (V) + JavaBean (M) + Servlet （C）的MVC结构进行编码实现


## 数据库设计
- - - -
1. 用户表：
![](README/3D048243-B9CA-48AB-8F20-2E9D66B972F2.png)

2. 预约表：
![](README/CAFE2568-3976-433B-A7DF-F750D9B8674E.png)
3. 餐桌表
![](README/B0F0C061-3F7E-4B6E-8F5D-EEDCE85112C9.png)

## 设计文档
#### 文件结构
- - - -
#### 逻辑层
> src/  
> __________bean/ —————————————————————————Model来存储和操作数据  
> ____________________Reservation.java__________存储预约对象       
> ____________________ReservationList.java__________存储预约列表  
> ____________________Table.java__________存储餐桌对象  
>  ____________________TableList.java__________存储餐桌列表  
>  ____________________users.java__________存储用户  
> __________Controller/ ————————————————————-Controller来处理逻辑操作  
> ____________________Reservation_edit.java__________修改预约  
> ____________________Reservation_end.java__________完成预约  
> ____________________Reservation_over.java__________记录到达  
> ____________________ReservationController.java________预约逻辑控制核心  
> ____________________R_deleteController.java_________删除预约  
> ____________________NewReservation.java__________新建预约  
> ____________________LoginCheck.java__________登陆检查  
> ____________________registerCheck.java__________注册检查  
> __________Dao/—————————————————————————-Dao进行持久化数据处理  
> ____________________DBconnect.java__________数据库连接与操作  
> __________Service/————————————————————Service来进行较为复杂的操作  
> ____________________Login.java__________登陆验证  

#### 视图层
> web/  
> Reservation_list.jsp  
> Table_list.jsp  
> xxxxx.jsp  
>   *以下为视图层依赖目录*  
> ____________css/  
> ____________img/  
> ____________js/  
> ____________lib/  
> ____________static/  

![P15SAg.png](https://s1.ax1x.com/2018/07/19/P15SAg.png)

# License
- - - -
https://github.com/jackying/h-ui
# contributor
https://github.com/Lcanboom





