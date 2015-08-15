rfm_data = LOAD '/data/train1000.csv' USING PigStorage(',') AS (custid:int, date:chararray, amount:float)

cust_id_amount = FOREACH rfm_data generate custid, amount;

custid_group = GROUP cust_id_amount BY custid;

monitory = FOREACH custid_group GENERATE group, SUM(cust_id_amount.amount);