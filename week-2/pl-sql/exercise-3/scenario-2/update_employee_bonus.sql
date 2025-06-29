CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
    p_Department IN VARCHAR2,
    p_Bonus IN NUMBER
) IS
    v_updated_count NUMBER;
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * p_Bonus / 100)
    WHERE Department = p_Department;

    v_updated_count := SQL%ROWCOUNT;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('Bonus applied to ' || v_updated_count || ' employee(s) in department: ' || p_Department);
END;
/

SET SERVEROUTPUT ON;

BEGIN
    UpdateEmployeeBonus('IT', 10);  -- Applies 10% bonus to IT department
END;
/

SELECT Name, Department, Salary FROM Employees WHERE Department = 'IT';

