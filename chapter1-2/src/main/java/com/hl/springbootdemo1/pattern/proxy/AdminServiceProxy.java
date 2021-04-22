package com.hl.springbootdemo1.pattern.proxy;

/**
 * 代理类
 */
public class AdminServiceProxy implements AdminService {
    private AdminService adminService;

    public AdminServiceProxy(AdminService adminService) {
        this.adminService = adminService;
    }

    @Override
    public void update() {
        System.out.println("判断用户是否有权限进行update操作");
        adminService.update();
        System.out.println("记录用户进行update操作的用户信息，修改内容和时间等");

    }

    @Override
    public Object find() {
        System.out.println("判断用户是否有权限进行find操作");
        System.out.println("记录用户进行find操作的用户信息，查看的内容和时间等");
        return adminService.find();
    }
}
