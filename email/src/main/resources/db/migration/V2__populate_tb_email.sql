INSERT INTO tb_email (
    email_id,
    user_id,
    email_to,
    email_from,
    email_subject,
    body,
    status_email,
    send_date_email
) VALUES
    (
        '660e8400-e29b-41d4-a716-446655440001',
        '550e8400-e29b-41d4-a716-446655440001',
        'maria.silva@example.com',
        'no-reply@example.com',
        'Email de teste',
        'Este e um email de teste para Maria Silva.',
        0,
        '2026-01-15 10:00:00'
    ),
    (
        '660e8400-e29b-41d4-a716-446655440002',
        '550e8400-e29b-41d4-a716-446655440002',
        'joao.santos@example.com',
        'no-reply@example.com',
        'Confirmacao de cadastro',
        'Este e um email de teste para Joao Santos.',
        1,
        '2026-01-15 10:05:00'
    );
