ALTER TABLE Customers
ADD IsVIP VARCHAR2(5);


SET SERVEROUTPUT ON;

BEGIN
    FOR res IN (
        SELECT c.Name, c.CustomerID, l.LoanID, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(res.CustomerID || ' - ' || res.Name || 
            ' → Your loan (Loan ID: ' || res.LoanID || 
            ') is due on ' || TO_CHAR(res.EndDate, 'DD-MON-YYYY') || '.');
    END LOOP;
END;
/

SELECT Name, Balance, IsVIP FROM Customers;

