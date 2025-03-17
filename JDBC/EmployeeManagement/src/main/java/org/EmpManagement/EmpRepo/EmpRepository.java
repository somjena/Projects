package org.EmpManagement.EmpRepo;

public interface EmpRepository {
    public void registerEmp();
    public void updateEmp();
    public void deleteEmp();
    public void empDetails();
    public void getDetailsByid();
    public int getId();
    public void exit();
}
