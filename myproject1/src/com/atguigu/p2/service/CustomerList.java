package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

public class CustomerList {
    private Customer[] customers;//用来保存客户对象的数组
    private int total =  0;// 记录已经保存的客户对象的数量

    public CustomerList(int totalCustomer){
        customers = new Customer[totalCustomer];
    }
    /*
    @Description 将指定客户添加到数组中
    @auther
    @param customer
    @return true:添加成功 false:添加失败
 */
    public boolean addCustomer(Customer customer){
        if(customer != null && total < customers.length){
            return false;
        }
        customers[total] = customer;
        total++;
        return true;
    }
    public boolean replaceCustomer(int index,Customer cust){
        if(index < 0 || index >= total){
            return false;
        }
        customers[index] = cust;
        return true;
    }
    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }
        for(int i = index; i < total - 1; i++){
            customers[i] = customers[i+1];
        }
        customers[total] = null;
        total--;
        return true;
    }
    /*
        @Description 获取所有用户的信息
        @auther
        @param customer
     */
    public Customer[] getAllCustomers(){
        Customer[] cust = new Customer[total];
        for(int i = 0; i < total; i++){
            cust[i] = customers[i];
        }
        return cust;
    }
    /*
       @Description 获取指定索引位置上的用户信息
       @auther
       @param customer
       @return 如果找到了元素，则返回
     */

    public Customer getCustomer(int index){
        if(index < 0 || index >= total){
            return null;
        }
        return customers[index];
    }
    public int getTotal(){
        return total;

    }
}
