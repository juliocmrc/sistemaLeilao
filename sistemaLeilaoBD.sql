PGDMP         .    
            w            pooII    9.5.2    11.2     N           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                       false            O           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                       false            P           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                       false            Q           1262    16393    pooII    DATABASE     �   CREATE DATABASE "pooII" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE "pooII";
             postgres    false                        2615    2200    public    SCHEMA        CREATE SCHEMA public;
    DROP SCHEMA public;
             postgres    false            R           0    0    SCHEMA public    COMMENT     6   COMMENT ON SCHEMA public IS 'standard public schema';
                  postgres    false    6            S           0    0    SCHEMA public    ACL     �   REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;
                  postgres    false    6            �            1259    16409    lances    TABLE     x   CREATE TABLE public.lances (
    id integer NOT NULL,
    pessoa_id integer NOT NULL,
    leilao_id integer NOT NULL
);
    DROP TABLE public.lances;
       public         postgres    false    6            �            1259    16407    lances_id_seq    SEQUENCE     v   CREATE SEQUENCE public.lances_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 $   DROP SEQUENCE public.lances_id_seq;
       public       postgres    false    185    6            T           0    0    lances_id_seq    SEQUENCE OWNED BY     ?   ALTER SEQUENCE public.lances_id_seq OWNED BY public.lances.id;
            public       postgres    false    184            �            1259    16427    leiloes_seq    SEQUENCE     t   CREATE SEQUENCE public.leiloes_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 "   DROP SEQUENCE public.leiloes_seq;
       public       postgres    false    6            �            1259    16402    leiloes    TABLE     �   CREATE TABLE public.leiloes (
    id integer DEFAULT nextval('public.leiloes_seq'::regclass) NOT NULL,
    item character varying(200) NOT NULL,
    precoinicial numeric(20,0) NOT NULL,
    situacao character varying(20) NOT NULL
);
    DROP TABLE public.leiloes;
       public         postgres    false    186    6            �            1259    16396    pessoas    TABLE     �   CREATE TABLE public.pessoas (
    id integer NOT NULL,
    nome character varying(400) NOT NULL,
    sexo character varying(1),
    cpf character varying(14) NOT NULL
);
    DROP TABLE public.pessoas;
       public         postgres    false    6            �            1259    16394    pessoas_id_seq    SEQUENCE     w   CREATE SEQUENCE public.pessoas_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.pessoas_id_seq;
       public       postgres    false    182    6            U           0    0    pessoas_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.pessoas_id_seq OWNED BY public.pessoas.id;
            public       postgres    false    181            �           2604    16412 	   lances id    DEFAULT     f   ALTER TABLE ONLY public.lances ALTER COLUMN id SET DEFAULT nextval('public.lances_id_seq'::regclass);
 8   ALTER TABLE public.lances ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    184    185    185            �           2604    16399 
   pessoas id    DEFAULT     h   ALTER TABLE ONLY public.pessoas ALTER COLUMN id SET DEFAULT nextval('public.pessoas_id_seq'::regclass);
 9   ALTER TABLE public.pessoas ALTER COLUMN id DROP DEFAULT;
       public       postgres    false    181    182    182            J          0    16409    lances 
   TABLE DATA               :   COPY public.lances (id, pessoa_id, leilao_id) FROM stdin;
    public       postgres    false    185   �       H          0    16402    leiloes 
   TABLE DATA               C   COPY public.leiloes (id, item, precoinicial, situacao) FROM stdin;
    public       postgres    false    183          G          0    16396    pessoas 
   TABLE DATA               6   COPY public.pessoas (id, nome, sexo, cpf) FROM stdin;
    public       postgres    false    182   W       V           0    0    lances_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.lances_id_seq', 1, false);
            public       postgres    false    184            W           0    0    leiloes_seq    SEQUENCE SET     9   SELECT pg_catalog.setval('public.leiloes_seq', 2, true);
            public       postgres    false    186            X           0    0    pessoas_id_seq    SEQUENCE SET     =   SELECT pg_catalog.setval('public.pessoas_id_seq', 1, false);
            public       postgres    false    181            �           2606    16406    leiloes leiloes_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.leiloes
    ADD CONSTRAINT leiloes_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.leiloes DROP CONSTRAINT leiloes_pkey;
       public         postgres    false    183            �           2606    16401    pessoas pessoas_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.pessoas
    ADD CONSTRAINT pessoas_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.pessoas DROP CONSTRAINT pessoas_pkey;
       public         postgres    false    182            �           2606    16414    lances pk_lances 
   CONSTRAINT     N   ALTER TABLE ONLY public.lances
    ADD CONSTRAINT pk_lances PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.lances DROP CONSTRAINT pk_lances;
       public         postgres    false    185            �           2606    16415    lances fk_leilao_lances    FK CONSTRAINT     z   ALTER TABLE ONLY public.lances
    ADD CONSTRAINT fk_leilao_lances FOREIGN KEY (leilao_id) REFERENCES public.leiloes(id);
 A   ALTER TABLE ONLY public.lances DROP CONSTRAINT fk_leilao_lances;
       public       postgres    false    185    1999    183            �           2606    16420    lances fk_pessoas_lances    FK CONSTRAINT     {   ALTER TABLE ONLY public.lances
    ADD CONSTRAINT fk_pessoas_lances FOREIGN KEY (pessoa_id) REFERENCES public.pessoas(id);
 B   ALTER TABLE ONLY public.lances DROP CONSTRAINT fk_pessoas_lances;
       public       postgres    false    1997    182    185            J      x������ � �      H   E   x�3�L�/�W��O��4600�ttr
��2�I,H-IU�=�0=39_!%_�1'1%3��� `*c���� �G�      G      x������ � �     