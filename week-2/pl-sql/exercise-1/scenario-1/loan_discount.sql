SET SERVEROUTPUT ON;

BEGIN
    FOR res IN (
        SELECT c.Name, c.CustomerID, l.LoanID, l.InterestRate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.DOB) / 12) > 60
    ) LOOP
        UPDATE Loans
        SET InterestRate = res.InterestRate - 1
        WHERE LoanID = res.LoanID;

        DBMS_OUTPUT.PUT_LINE('Updated interest rate for customer: ' || res.Name);
    END LOOP;
END;
/

SELECT * FROM Loans