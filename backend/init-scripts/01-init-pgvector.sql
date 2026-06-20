-- Enable pgvector extension
CREATE EXTENSION IF NOT EXISTS vector;

-- Create database if not exists
SELECT 'CREATE DATABASE aihealthcare'
WHERE NOT EXISTS (SELECT FROM pg_database WHERE datname = 'aihealthcare')\gexec

\c aihealthcare;

-- Enable pgvector extension in aihealthcare database
CREATE EXTENSION IF NOT EXISTS vector;

-- Create tables for Spring AI Vector Store
CREATE TABLE IF NOT EXISTS vector_store (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    content TEXT NOT NULL,
    metadata JSONB,
    embedding VECTOR(768)
);

CREATE INDEX IF NOT EXISTS vector_store_embedding_idx ON vector_store
USING hnsw (embedding vector_cosine_ops);

-- Create document_data table
CREATE TABLE IF NOT EXISTS document_data (
    id BIGSERIAL PRIMARY KEY,
    content TEXT,
    file_name VARCHAR(255)
);

-- Create document_embeddings table with vector support
CREATE TABLE IF NOT EXISTS document_embeddings (
    id BIGSERIAL PRIMARY KEY,
    document_id BIGINT,
    content TEXT,
    embedding VECTOR(768)
);

CREATE INDEX IF NOT EXISTS document_embeddings_embedding_idx ON document_embeddings
USING hnsw (embedding vector_cosine_ops);

-- Grant permissions
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO postgres;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO postgres;