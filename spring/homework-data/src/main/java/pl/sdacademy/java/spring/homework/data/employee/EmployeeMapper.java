package pl.sdacademy.java.spring.homework.data.employee;

/**
 * Mapowanie między typem DTO a klasą encyjną.
 *
 * Dla chętnych: spróbować wykorzystać np. MapStruct
 */
public interface EmployeeMapper {
    Employee map(EmployeeDto employeeDto);
    EmployeeDto map(Employee employee);
}
