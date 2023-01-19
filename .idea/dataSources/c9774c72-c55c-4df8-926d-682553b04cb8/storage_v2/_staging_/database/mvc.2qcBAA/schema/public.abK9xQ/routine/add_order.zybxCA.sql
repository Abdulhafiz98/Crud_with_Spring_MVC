create function add_order(i_user integer, i_product integer) returns void
    language plpgsql
as
$$
declare
    v_chat_id int;
BEGIN
      select id into v_chat_id from mvc_user where chat_id = i_user_chat_id;
      update basket set taken=false where productid=i_product and userid=i_user;
      insert into mvc_orderTible(userId, productId) VALUES (i_user,i_product);
end
$$;

alter function add_order(integer, integer) owner to postgres;
--  =====================
drop function add_order;

create function add_order(i_user integer, i_product varchar) returns void
    language plpgsql
as
$$
declare
    v_chat_id int;
    v_pro_id int;
BEGIN
    select id into v_chat_id from mvc_user where chat_id = i_user_chat_id;
    select id into v_pro_id from product_1 where name =i_product;

    if v_pro_id is not null and v_chat_id is not null then
        update basket set taken=false where productid=v_pro_id and userid=v_chat_id;
        insert into mvc_orderTible(userId, productId) VALUES (v_chat_id,v_pro_id);
    end if;


end
$$;

alter function add_order(integer, integer) owner to postgres;
