
--用户临时表
CREATE TABLE [dbo].[t_temp_user](
	[sid] [int] primary key identity,     --id
	[user_code] [varchar](256) NULL,     --用户编码
	[oper_date] [datetime] default getdate()   --获取时间
)


--用户表
CREATE TABLE [dbo].[t_user](
	[sid] [int] primary key identity,     --id
	[user_code] [varchar](256) NULL,     --用户编码
	[user_name] [varchar](512) NULL,     --用户名
	[user_age][varchar](256) NULL,       --吧龄
	[fans] [int] NULL,                   --粉丝数量
	[pv] [int] NULL,                     --访问量
	[oper_date] [datetime] default getdate(),   --获取时间
	[user_flag][varchar](16) default 0          
)

--发表内容表
CREATE TABLE [dbo].[t_post](
	[sid] [int] primary key identity,     --id
	[post_id] [varchar](256) NULL,       --文章唯一id，由股票吧代码和post_id组成
	[user_code] [varchar](256) NULL,     --用户编码
	[title] [varchar](8000) NULL,         --标题
	[content][varchar](max) NULL,       --内容
	[pubtime] [varchar](256) NULL,               --发表时间
	[pv] [varchar](12) NULL,                     --访问量
	[oper_date] [datetime] default getdate()   --获取时间
)

--评论表
CREATE TABLE [dbo].[t_post_comment](
	[sid] [int] primary key identity,    --id
	[post_id] [varchar](256) NULL,       --文章唯一id，和内容表中一致  
	[user_code] [varchar](256) NULL,     --文章用户编码
	[pub_user_code] [varchar](512) NULL,  --发表人姓名
	[pub_user_name] [varchar](512) NULL,  --发表人姓名
	[content][varchar](max) NULL,       --内容
	[pubtime] [varchar](256) NULL,               --发表时间
	[oper_date] [datetime] default getdate()   --获取时间
)




