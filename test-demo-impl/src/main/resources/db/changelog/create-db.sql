--DROP USER chargeback;
CREATE USER postgres WITH PASSWORD 'postgres';

--DROP DATABASE svpc_intgr_chargeback;
CREATE DATABASE test WITH
    OWNER postgres
    ENCODING 'UTF8';