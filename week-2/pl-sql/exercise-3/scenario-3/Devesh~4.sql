CREATE OR REPLACE PROCEDURE TransferFunds (
    from_account IN NUMBER,
    to_account   IN NUMBER,
    amount       IN NUMBER
) IS
    v_balance NUMBER;
BEGIN
    SELECT balance INTO v_balance
    FROM accounts
    WHERE accountid = from_account
    FOR UPDATE;

    IF v_balance < amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient Balance');
    END IF;

    UPDATE accounts
    SET balance = balance - amount,
        lastModified = SYSDATE
    WHERE accountid = from_account;

    UPDATE accounts
    SET balance = balance + amount,
        lastModified = SYSDATE
    WHERE accountid = to_account;

    COMMIT;
       DBMS_OUTPUT.PUT_LINE('Transfer of ₹' || amount || ' from ' || from_account || ' to ' || to_account || ' completed.');
EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Transfer failed: ' || SQLERRM);
END;
/

SET SERVEROUTPUT ON;

BEGIN
    TransferFunds(1, 2, 300);  -- Transfer ₹300 from account 1 to 2
END;
/

SELECT AccountID, Balance FROM Accounts WHERE AccountID IN (1, 2);
