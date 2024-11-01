drop database cwea_master;
create database cwea_master collate utf8mb4_general_ci;


use cwea_master;

create table api_config
(
    id          bigint primary key auto_increment comment '主键',
    api_time    int comment 'API请求次数',
    api_token   varchar(200) comment '随机生成的token',
    expire      int default 0 comment '是否过期',
    create_time datetime comment '创建时间'
) comment 'API配置表';

create table weather_config
(
    id          bigint auto_increment primary key comment '主键',
    status      varchar(10) comment '返回状态',
    api_version varchar(10) comment 'api 版本',
    api_status  varchar(10) comment 'api 状态',
    lang        varchar(10) comment '语言',
    unit        varchar(10) comment '单位制，metric表示公制',
    tzshift     int comment '时区偏移秒数',
    timezone    varchar(50) comment '时区信息',
    server_time int comment '服务器时间戳',
    latitude    decimal(9, 6) comment '纬度',
    longitude   decimal(9, 6) comment '经度',
    type        int comment '1-实时数据;2-分钟级;3-小时级别;4-天级别',
    result_id   bigint comment '_weather系列表的主键',
    create_time datetime comment '创建时间'
) comment '天气请求配置表';



create table realtime_weather
(
    id                              bigint primary key auto_increment comment '主键',
    status                          varchar(200) comment '状态',
    temperature                     int comment '地表 2 米气温',
    humidity                        decimal(9, 2) comment '地表 2 米湿度相对湿度(%)',
    cloudrate                       decimal(9, 2) comment '总云量(0.0-1.0)',
    skycon                          varchar(200) comment '天气现象',
    visibility                      decimal(9, 2) comment '地表水平能见度',
    dswrf                           decimal(9, 2) comment '向下短波辐射通量(w/m2)',
    wind_speed                      decimal(9, 2) comment '地表 10 米风速',
    wind_direction                  decimal(9, 2) comment '地表 10 米风向',
    pressure                        decimal(9, 2) comment '地面气压',
    apparent_temperature            decimal(9, 2) comment '体感温度',
    precipitation_local_status      varchar(200) comment '本地降水状态',
    precipitation_local_datasource  varchar(200) comment '本地降水数据来源',
    precipitation_local_intensity   int comment '本地降水强度',
    precipitation_nearest_status    varchar(200) comment '最近降水状态',
    precipitation_nearest_distance  int comment '最近降水带与本地的距离（米）',
    precipitation_nearest_intensity int comment '最近降水强度',
    air_quality_pm25                int comment 'pm2.5 浓度（μg/m3）',
    air_quality_pm10                int comment 'pm10 浓度（μg/m3）',
    air_quality_o3                  int comment '臭氧浓度（μg/m3）',
    air_quality_so2                 int comment '二氧化硫浓度（μg/m3）',
    air_quality_no2                 int comment '二氧化氮浓度（μg/m3）',
    air_quality_co                  decimal(9, 2) comment '一氧化碳浓度（mg/m3）',
    air_quality_aqi_chn             int comment '中国标准 aqi',
    air_quality_aqi_usa             int comment '美国标准 aqi',
    air_quality_description_chn     varchar(200) comment '中国 aqi 描述',
    air_quality_description_usa     varchar(200) comment '美国 aqi 描述',
    life_index_ultraviolet_index    int comment '紫外线指数',
    life_index_ultraviolet_desc     varchar(200) comment '紫外线描述',
    life_index_comfort_index        int comment '舒适度指数',
    life_index_comfort_desc         varchar(200) comment '舒适度描述',
    forecast_time                   datetime comment '预报时间',
    create_time                     datetime comment '创建时间'
) comment '实况天气信息表';



CREATE TABLE minute_weather
(
    id                bigint auto_increment primary key comment '主键',
    status            varchar(200) comment '分钟级预报状态',
    datasource        varchar(200) comment '数据源',
    precipitation_2h  varchar(200) comment '未来2小时每分钟的雷达降水强度',
    precipitation     varchar(200) comment '未来1小时每分钟的雷达降水强度',
    probability       varchar(200) comment '未来两小时每半小时的降水概率',
    description       varchar(100) comment '预报描述',
    primary_forecast  int comment '主要预报',
    forecast_keypoint varchar(100) comment '预报关键点',
    forecast_time     datetime comment '预报时间',
    create_time       datetime comment '创建时间'
) comment '分钟级天气信息表';



CREATE TABLE hourly_weather
(
    id                            bigint auto_increment primary key comment '主键',
    status                        varchar(200) comment '小时级别预报状态',
    description                   varchar(200) comment '未来24小时天气描述',
    primary_forecast              int comment '主要预报',
    forecast_keypoint             varchar(200) comment '天气预报关键点',
    precipitation_datetime        datetime comment '降水时间',
    precipitation_value           decimal(9, 2) comment '降水量',
    precipitation_probability     decimal(9, 2) comment '降水概率',
    temperature_datetime          datetime comment '气温时间',
    temperature_value             decimal(9, 2) comment '地表2米气温',
    apparent_temperature_datetime datetime comment '体感温度时间',
    apparent_temperature_value    decimal(9, 2) comment '体感温度',
    wind_datetime                 datetime comment '风数据时间',
    wind_speed                    decimal(9, 2) comment '风速',
    wind_direction                int comment '风向',
    humidity_datetime             datetime comment '湿度时间',
    humidity_value                decimal(9, 2) comment '相对湿度',
    cloudrate_datetime            datetime comment '云量时间',
    cloudrate_value               decimal(9, 2) comment '云量',
    skycon_datetime               datetime comment '天气现象时间',
    skycon_value                  varchar(200) comment '天气现象',
    pressure_datetime             datetime comment '气压时间',
    pressure_value                decimal(10, 6) comment '地面气压',
    visibility_datetime           datetime comment '能见度时间',
    visibility_value              decimal(9, 2) comment '水平能见度',
    dswrf_datetime                datetime comment '辐射通量时间',
    dswrf_value                   decimal(10, 6) comment '向下短波辐射通量',
    air_quality_datetime          datetime comment '空气质量时间',
    air_quality_aqi_chn           int comment '中国 aqi',
    air_quality_aqi_usa           int comment '美国 aqi',
    air_quality_pm25              decimal(9, 2) comment 'pm2.5浓度',
    forecast_time                 datetime comment '预报时间',
    create_time                   datetime comment '创建时间'
) comment '小时级天气信息表';


create table daily_weather
(
    id                                bigint auto_increment primary key comment '主键',
    status                            varchar(200) comment '日预报状态',
    primary_forecast                  int comment '主要预报',
    astro_date                        datetime comment '日期',
    sunrise_time                      time comment '日出时间',
    sunset_time                       time comment '日落时间',
    precipitation_08h_20h_date        datetime comment '白天降水日期',
    precipitation_08h_20h_max         decimal(9, 2) comment '白天最大降水量',
    precipitation_08h_20h_min         decimal(9, 2) comment '白天最小降水量',
    precipitation_08h_20h_avg         decimal(9, 2) comment '白天平均降水量',
    precipitation_08h_20h_probability decimal(9, 2) comment '白天降水概率',
    precipitation_20h_32h_date        datetime comment '夜晚降水日期',
    precipitation_20h_32h_max         decimal(9, 2) comment '夜晚最大降水量',
    precipitation_20h_32h_min         decimal(9, 2) comment '夜晚最小降水量',
    precipitation_20h_32h_avg         decimal(9, 2) comment '夜晚平均降水量',
    precipitation_20h_32h_probability decimal(9, 2) comment '夜晚降水概率',
    precipitation_date                datetime comment '全天降水日期',
    precipitation_max                 decimal(9, 2) comment '全天最大降水量',
    precipitation_min                 decimal(9, 2) comment '全天最小降水量',
    precipitation_avg                 decimal(9, 2) comment '全天平均降水量',
    precipitation_probability         decimal(9, 2) comment '全天降水概率',
    temperature_date                  datetime comment '气温日期',
    temperature_max                   decimal(9, 2) comment '全天最高气温',
    temperature_min                   decimal(9, 2) comment '全天最低气温',
    temperature_avg                   decimal(9, 2) comment '全天平均气温',
    temperature_08h_20h_date          datetime comment '白天气温日期',
    temperature_08h_20h_max           decimal(9, 2) comment '白天最高气温',
    temperature_08h_20h_min           decimal(9, 2) comment '白天最低气温',
    temperature_08h_20h_avg           decimal(9, 2) comment '白天平均气温',
    temperature_20h_32h_date          datetime comment '夜晚气温日期',
    temperature_20h_32h_max           decimal(9, 2) comment '夜晚最高气温',
    temperature_20h_32h_min           decimal(9, 2) comment '夜晚最低气温',
    temperature_20h_32h_avg           decimal(9, 2) comment '夜晚平均气温',
    wind_date                         datetime comment '风速日期',
    wind_max_speed                    decimal(9, 2) comment '全天最大风速',
    wind_max_direction                decimal(9, 2) comment '全天最大风向',
    wind_min_speed                    decimal(9, 2) comment '全天最小风速',
    wind_min_direction                decimal(9, 2) comment '全天最小风向',
    wind_avg_speed                    decimal(9, 2) comment '全天平均风速',
    wind_avg_direction                decimal(9, 2) comment '全天平均风向',
    wind_08h_20h_date                 datetime comment '白天风速日期',
    wind_08h_20h_max_speed            decimal(9, 2) comment '白天最大风速',
    wind_08h_20h_max_direction        decimal(9, 2) comment '白天最大风向',
    wind_08h_20h_min_speed            decimal(9, 2) comment '白天最小风速',
    wind_08h_20h_min_direction        decimal(9, 2) comment '白天最小风向',
    wind_08h_20h_avg_speed            decimal(9, 2) comment '白天平均风速',
    wind_08h_20h_avg_direction        decimal(9, 2) comment '白天平均风向',
    wind_20h_32h_date                 datetime comment '夜晚风速日期',
    wind_20h_32h_max_speed            decimal(9, 2) comment '夜晚最大风速',
    wind_20h_32h_max_direction        decimal(9, 2) comment '夜晚最大风向',
    wind_20h_32h_min_speed            decimal(9, 2) comment '夜晚最小风速',
    wind_20h_32h_min_direction        decimal(9, 2) comment '夜晚最小风向',
    wind_20h_32h_avg_speed            decimal(9, 2) comment '夜晚平均风速',
    wind_20h_32h_avg_direction        decimal(9, 2) comment '夜晚平均风向',
    humidity_date                     datetime comment '湿度日期',
    humidity_max                      decimal(9, 2) comment '最大湿度',
    humidity_min                      decimal(9, 2) comment '最小湿度',
    humidity_avg                      decimal(9, 2) comment '平均湿度',
    cloudrate_date                    datetime comment '云量日期',
    cloudrate_max                     decimal(9, 2) comment '最大云量',
    cloudrate_min                     decimal(9, 2) comment '最小云量',
    cloudrate_avg                     decimal(9, 2) comment '平均云量',
    pressure_date                     datetime comment '气压日期',
    pressure_max                      decimal(10, 2) comment '最大气压',
    pressure_min                      decimal(10, 2) comment '最小气压',
    pressure_avg                      decimal(10, 2) comment '平均气压',
    visibility_date                   datetime comment '能见度日期',
    visibility_max                    decimal(9, 2) comment '最大能见度',
    visibility_min                    decimal(9, 2) comment '最小能见度',
    visibility_avg                    decimal(9, 2) comment '平均能见度',
    dswrf_date                        datetime comment '辐射通量日期',
    dswrf_max                         decimal(10, 2) comment '最大辐射通量',
    dswrf_min                         decimal(10, 2) comment '最小辐射通量',
    dswrf_avg                         decimal(10, 2) comment '平均辐射通量',
    air_quality_date                  datetime comment '空气质量日期',
    air_quality_aqi_max_chn           int comment '中国 aqi 最大值',
    air_quality_aqi_max_usa           int comment '美国 aqi 最大值',
    air_quality_aqi_avg_chn           int comment '中国 aqi 平均值',
    air_quality_aqi_avg_usa           int comment '美国 aqi 平均值',
    air_quality_aqi_min_chn           int comment '中国 aqi 最小值',
    air_quality_aqi_min_usa           int comment '美国 aqi 最小值',
    pm25_date                         datetime comment 'pm2.5 日期',
    pm25_max                          decimal(9, 2) comment 'pm2.5 最大浓度',
    pm25_avg                          decimal(9, 2) comment 'pm2.5 平均浓度',
    pm25_min                          decimal(9, 2) comment 'pm2.5 最小浓度',
    skycon_date                       datetime comment '天气现象日期',
    skycon_value                      varchar(200) comment '全天主要天气现象',
    skycon_08h_20h_value              varchar(200) comment '白天主要天气现象',
    skycon_20h_32h_value              varchar(200) comment '夜晚主要天气现象',
    life_index_date                   datetime comment '生活指数日期',
    ultraviolet_index                 int comment '紫外线指数',
    ultraviolet_desc                  varchar(200) comment '紫外线描述',
    carwashing_index                  int comment '洗车指数',
    carwashing_desc                   varchar(200) comment '洗车描述',
    dressing_index                    int comment '穿衣指数',
    dressing_desc                     varchar(200) comment '穿衣描述',
    comfort_index                     int comment '舒适度指数',
    forecast_time                     datetime comment '预报时间',
    create_time                       datetime comment '创建时间'
) comment '天级天气信息表';


CREATE TABLE weather_alert
(
    id                bigint auto_increment primary key comment '主键',
    status            varchar(200) comment '预警信息状态',
    alert_province    varchar(200) comment '省份',
    alert_status      varchar(200) comment '预警状态',
    alert_code        varchar(200) comment '预警代码',
    alert_description text comment '预警描述',
    region_id         varchar(200) comment '地区 id',
    county            varchar(200) comment '县区',
    pub_timestamp     int comment '发布时间戳',
    lat               decimal(9, 6) comment '纬度',
    lon               decimal(9, 6) comment '经度',
    alert_city        varchar(200) comment '城市',
    alert_id          varchar(200) comment '预警 id',
    alert_title       varchar(100) comment '预警标题',
    adcode            varchar(200) comment '区域代码',
    adcode_name       varchar(200) comment '区域名称',
    source            varchar(100) comment '预警信息来源',
    location          varchar(100) comment '地点',
    request_status    varchar(200) comment '请求状态',
    forecast_time     datetime comment '预报时间',
    create_time       datetime comment '创建时间'
) comment '天气预警信息表';

create table weather_condition_dict
(
    id             bigint auto_increment primary key comment '主键',
    condition_name varchar(20) comment '天气现象名称',
    condition_code varchar(20) comment '天气现象代码',
    description    varchar(100) comment '天气条件描述'
) comment '天气现象字典表';

insert into weather_condition_dict (condition_name, condition_code, description)
values ('晴（白天）', 'CLEAR_DAY', 'cloudrate < 0.2'),
       ('晴（夜间）', 'CLEAR_NIGHT', 'cloudrate < 0.2'),
       ('多云（白天）', 'PARTLY_CLOUDY_DAY', '0.8 >= cloudrate > 0.2'),
       ('多云（夜间）', 'PARTLY_CLOUDY_NIGHT', '0.8 >= cloudrate > 0.2'),
       ('阴', 'CLOUDY', 'cloudrate > 0.8'),
       ('轻度雾霾', 'LIGHT_HAZE', 'PM2.5 100 ~ 150'),
       ('中度雾霾', 'MODERATE_HAZE', 'PM2.5 150 ~ 200'),
       ('重度雾霾', 'HEAVY_HAZE', 'PM2.5 > 200'),
       ('小雨', 'LIGHT_RAIN', '降水强度：小雨'),
       ('中雨', 'MODERATE_RAIN', '降水强度：中雨'),
       ('大雨', 'HEAVY_RAIN', '降水强度：大雨'),
       ('暴雨', 'STORM_RAIN', '降水强度：暴雨'),
       ('雾', 'FOG', '能见度低，湿度高，风速低，温度低'),
       ('小雪', 'LIGHT_SNOW', '降水强度：小雪'),
       ('中雪', 'MODERATE_SNOW', '降水强度：中雪'),
       ('大雪', 'HEAVY_SNOW', '降水强度：大雪'),
       ('暴雪', 'STORM_SNOW', '降水强度：暴雪'),
       ('浮尘', 'DUST', 'AQI > 150, PM10 > 150，湿度 < 30%，风速 < 6 m/s'),
       ('沙尘', 'SAND', 'AQI > 150, PM10> 150，湿度 < 30%，风速 > 6 m/s'),
       ('大风', 'WIND', '高风速');


create table air_pollution_dict
(
    id       bigint auto_increment primary key comment '主键',
    aqi_desc varchar(100) comment 'AQI 描述'
) comment '空气污染字典表';

insert into air_pollution_dict(aqi_desc)
values ('缺数据'),
       ('优'),
       ('良'),
       ('轻度污染'),
       ('中度污染'),
       ('重度污染'),
       ('严重污染');

create table ultraviolet_realtime_dict
(
    id         bigint auto_increment primary key comment '主键',
    level_desc varchar(100) comment '等级描述'
) comment '紫外线底字典表（实况级别）';

insert into ultraviolet_realtime_dict(id, level_desc)
values (0, '无'),
       (1, '很弱'),
       (2, '很弱'),
       (3, '弱'),
       (4, '弱'),
       (5, '中等'),
       (6, '中等'),
       (7, '强'),
       (8, '强'),
       (9, '强'),
       (10, '很强'),
       (11, '很强');

create table ultraviolet_daily_dict
(
    id         bigint auto_increment primary key comment '主键',
    level_desc varchar(100) comment '等级描述'
) comment '紫外线底字典表（天级别）';

insert into ultraviolet_daily_dict(level_desc)
values ('很弱'),
       ('弱'),
       ('中等'),
       ('强'),
       ('很强');

create table dressing_dict
(

    id          bigint auto_increment primary key comment '主键',
    description varchar(100) comment '描述'
) comment '穿衣指数字典表';

insert into dressing_dict(id, description)
values (0, '极热'),
       (1, '极热'),
       (2, '很热'),
       (3, '热'),
       (4, '温暖'),
       (5, '凉爽'),
       (6, '冷'),
       (7, '寒冷'),
       (8, '极冷');

create table comfort_dict
(

    id          bigint auto_increment primary key comment '主键',
    description varchar(100) comment '描述'
) comment '舒适度指数字典表';

insert into comfort_dict(id, description)
values (0, '闷热'),
       (1, '酷热'),
       (2, '很热'),
       (3, '热'),
       (4, '温暖'),
       (5, '舒适'),
       (6, '凉爽'),
       (7, '冷'),
       (8, '很冷'),
       (9, '寒冷'),
       (10, '极冷'),
       (11, '刺骨的冷'),
       (12, '湿冷'),
       (13, '干冷');


create table coldRisk_dict
(

    id          bigint auto_increment primary key comment '主键',
    description varchar(100) comment '描述'
) comment '感冒指数字典表';

insert into coldRisk_dict(description)
values ('少发'),
       ('较易发'),
       ('易发'),
       ('极易发');

create table carWashing_dict
(

    id          bigint auto_increment primary key comment '主键',
    description varchar(100) comment '描述'
) comment '洗车指数字典表';

insert into carWashing_dict(description)
values ('适宜'),
       ('较适宜'),
       ('较不适宜'),
       ('不适宜');


create table precipitation_condition_dict
(
    id                    bigint auto_increment primary key comment '主键',
    precipitation_type    varchar(20) comment '降水类型 (雨/雪)',
    min_precipitation     float comment '最小降水量范围',
    max_precipitation     float comment '最大降水量范围，null 表示无上限',
    min_intensity         float comment '最小降水强度范围',
    max_intensity         float comment '最大降水强度范围，null 表示无上限',
    condition_description varchar(100) comment '降水等级描述'
) comment '降水强度字典表';

INSERT INTO precipitation_condition_dict (precipitation_type, min_precipitation, max_precipitation, min_intensity,
                                          max_intensity, condition_description)
VALUES ('无雨/雪', 0, 0.031, 0, 0.0606, '无雨/雪'),
       ('小雨/雪', 0.031, 0.25, 0.0606, 0.8989, '小雨/雪'),
       ('中雨/雪', 0.25, 0.35, 0.8989, 2.8700, '中雨/雪'),
       ('大雨/雪', 0.35, 0.48, 2.8700, 12.8638, '大雨/雪'),
       ('暴雨/雪', 0.48, NULL, 12.8638, NULL, '暴雨/雪');


create table wind_level_dict
(
    id                bigint auto_increment primary key comment '主键',
    min_speed         float comment '风速范围下限 (km/h)',
    max_speed         float comment '风速范围上限 (km/h)，null 表示无上限',
    min_intensity     float comment '风速强度范围下限 (m/s)',
    max_intensity     float comment '风速强度范围上限 (m/s)，null 表示无上限',
    level_description varchar(100) comment '风速等级描述'
) comment '风速等级字典表';

INSERT INTO wind_level_dict (id,min_speed, max_speed, min_intensity, max_intensity, level_description)
VALUES (0,0, 1, 0, 0.3, '无风'),
       (1,1, 5, 0.3, 1.6, '微风徐徐'),
       (2,6, 11, 1.6, 3.4, '清风'),
       (3,12, 19, 3.4, 5.5, '树叶摇摆'),
       (4,20, 28, 5.5, 8.0, '树枝摇动'),
       (5,29, 38, 8.0, 10.8, '风力强劲'),
       (6,39, 49, 10.8, 13.9, '风力强劲'),
       (7,50, 61, 13.9, 17.2, '风力超强'),
       (8,62, 74, 17.2, 20.8, '狂风大作'),
       (9,75, 88, 20.8, 24.5, '狂风呼啸'),
       (10,89, 102, 24.5, 28.5, '暴风毁树'),
       (11,103, 117, 28.5, 32.7, '暴风毁树'),
       (12,118, 133, 32.7, 37.0, '飓风'),
       (13,134, 149, 37.0, 41.5, '台风'),
       (14,150, 166, 41.5, 46.2, '强台风'),
       (15,167, 183, 46.2, 51.0, '强台风'),
       (16,184, 201, 51.0, 56.1, '超强台风'),
       (17,202, 220, 56.1, 61.3, '超强台风');

create table wind_direction_dict
(
    id             bigint auto_increment primary key comment '自增主键',
    direction_name varchar(20) comment '风向名称',
    abbreviation   varchar(5) comment '风向简称',
    angle          int comment '风向角度',
    min_angle      float comment '风向角度下限',
    max_angle      float comment '风向角度上限'
) comment '风向字典表';

INSERT INTO wind_direction_dict (direction_name, abbreviation, angle, min_angle, max_angle)
VALUES ('北', 'N', 0, 348.76, 11.25),
       ('北东北', 'NNE', 22.5, 11.26, 33.75),
       ('东北', 'NE', 45, 33.76, 56.25),
       ('东东北', 'ENE', 67.5, 56.26, 78.75),
       ('东', 'E', 90, 78.76, 101.25),
       ('东东南', 'ESE', 112.5, 101.26, 123.75),
       ('东南', 'SE', 135, 123.76, 146.25),
       ('南东南', 'SSE', 157.5, 146.26, 168.75),
       ('南', 'S', 180, 168.76, 191.25),
       ('南西南', 'SSW', 202.5, 191.26, 213.75),
       ('西南', 'SW', 225, 213.76, 236.25),
       ('西西南', 'WSW', 247.5, 236.26, 258.75),
       ('西', 'W', 270, 258.76, 281.25),
       ('西西北', 'WNW', 292.5, 281.26, 303.75),
       ('西北', 'NW', 315, 303.76, 326.25),
       ('北西北', 'NNW', 337.5, 326.26, 348.75);


CREATE TABLE http_status_code_dict
(
    code    INT PRIMARY KEY COMMENT 'HTTP 状态码',
    message VARCHAR(50) NOT NULL COMMENT '状态码说明'
) comment '错误信息字典表';


INSERT INTO http_status_code_dict (code, message)
VALUES (200, '请求成功'),
       (400, 'Token 不存在'),
       (401, 'Token 无权限'),
       (422, '参数错误'),
       (429, 'Token 额度已用完'),
       (500, '服务器错误');

create table sys_user
(
    id         bigint primary key auto_increment comment '主键',
    user_name  varchar(30)             not null comment '用户账号',
    nick_name  varchar(30)             not null comment '用户昵称',
    password   varchar(100) default '' null comment '密码',
    login_ip   varchar(128) default '' null comment '最后登录IP',
    login_date datetime                null comment '最后登录时间'
)
    comment '用户信息表';
