-- auto-generated definition
create table Reservation
(
  R_id         int auto_increment
    primary key,
  R_name       varchar(50)  null,
  R_tel        varchar(50)  null,
  R_sum        int          null,
  R_date       date         null,
  R_time_start datetime     null,
  R_time_end   datetime     null,
  E_time_start datetime     null,
  E_time_end   datetime     null,
  T_id         varchar(50)  null,
  R_pay        int          null,
  R_isWalkin   tinyint(1)   null,
  R_comment    varchar(200) null
)
  comment 'the table to save reservations';