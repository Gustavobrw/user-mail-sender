CREATE TABLE tb_email (
    email_id UUID PRIMARY KEY,
    user_id UUID,
    email_to VARCHAR(255),
    email_from VARCHAR(255),
    email_subject VARCHAR(255),
    body TEXT,
    status_email INTEGER,
    send_date_email TIMESTAMP
);
