# 佩奇餐饮管理系统
#Macbook/oop
- - - -
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

#### 主要事件用例图
- - - -

![](README/fuck.png)

#### 主要事件顺序图
- - - -
### 主要逻辑

![](README/660DEFB5-5621-4967-8152-1DC75D671F1F.png)

### 新建预约

![](README/0C089E17-468B-4E9E-9A35-41EFA1216668.png)

### 记录到达

![](README/CA83D74B-4F79-4A7D-A8E5-CA330F8C0824.png)

### 取消预约

![](README/ED221786-840E-4C11-9403-2BD16AC22F00.png)

### 修改预约

![](README/7249556B-E842-45D2-9716-BD399AC14793.png)

#### 主要类图设计

![](README/3A82C74A-D16B-4669-97BD-30C5A3800B0B.png)

## 软件操作
- - - -
### 操作截图

 登陆界面：
![](README/C338DA23-5225-44AE-A23E-5621E1D42761.png)
注册界面：

![](README/F80F8941-BD8B-4648-ADB2-40163CBF4326.png)
主界面：
![](README/E89781A0-32CF-406C-AD5B-EF716BD08610.png)
餐桌管理：
![](README/0C1866B5-A212-4B3E-A6B1-F01D551ED07A.png)
预约详情：
![](README/079DA040-47B8-40AF-88B8-4237322DB0D7.png)
确认到达：
![](README/EC9BC2F8-A2AB-4A0D-B92D-86764BFB288E.png)
预约列表：
![](README/814DC538-2E49-4610-AAB0-4A458B9D5697.png)
修改预约：
![](README/C5D00A4E-460D-4025-A02F-3C4EF0E4EB1D.png)
删除预约：
![](README/F047A6DD-0241-4552-9FBA-771632154527.png)
新建预约：
![](README/9E4399E1-7FF5-4C50-AADB-718BB99EAECB.png)
筛选餐桌：
![](README/9133AB62-36D9-409D-94B2-CB9FDC8D57BC.png)
预约完成：
![](README/6F5E9C24-DF44-4D8F-8ADC-01CF7AD87700.png)
                                 ![](README/62CB5B46-B403-4A5D-BB09-E4444E07959C.png)
![](README/0A860363-3799-4585-9757-A48F3EA58706.png)

# License
- - - -
[![forthebadge](https://forthebadge.com/images/badges/designed-in-H-ui.svg)](https://github.com/jackying/h-ui)
*contributor*
https://github.com/Lcanboom





