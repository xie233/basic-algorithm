package org.jim.structural.composite;

import java.util.List;

// 构建组织架构的代码
/*
组合模式，将一组对象组织成树形结构，将单个对象和组合对象都看做树中的节点，
以统一处理逻辑，并且它利用树形结构的特点，递归地处理每个子树，依次简化代码实现

 */
public class CompDemo {
//    private static final long ORGANIZATION_ROOT_ID = 1001;
//    private DepartmentRepo departmentRepo; // 依赖注入
//    private EmployeeRepo employeeRepo; // 依赖注入
//
//    public void buildOrganization() {
//        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
//        buildOrganization(rootDepartment);
//    }
//
//    private void buildOrganization(Department department) {
//        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
//        for (Long subDepartmentId : subDepartmentIds) {
//            Department subDepartment = new Department(subDepartmentId);
//            department.addSubNode(subDepartment);
//            buildOrganization(subDepartment);
//        }
//        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
//        for (Long employeeId : employeeIds) {
//            double salary = employeeRepo.getEmployeeSalary(employeeId);
//            department.addSubNode(new Employee(employeeId, salary));
//        }
//    }
}
