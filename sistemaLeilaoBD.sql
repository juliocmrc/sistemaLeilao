PGDMP     #    5                w            SistemaLeilao    12.1    12.1                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    16393    SistemaLeilao    DATABASE     �   CREATE DATABASE "SistemaLeilao" WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'Portuguese_Brazil.1252' LC_CTYPE = 'Portuguese_Brazil.1252';
    DROP DATABASE "SistemaLeilao";
                postgres    false            �            1259    16394    lances    TABLE     �   CREATE TABLE public.lances (
    cpf character varying NOT NULL,
    pessoa character varying NOT NULL,
    item character varying NOT NULL,
    valor real NOT NULL
);
    DROP TABLE public.lances;
       public         heap    postgres    false            �            1259    16397    leiloes    TABLE     �   CREATE TABLE public.leiloes (
    item character varying NOT NULL,
    precoinicial real NOT NULL,
    situacao character varying NOT NULL
);
    DROP TABLE public.leiloes;
       public         heap    postgres    false            �            1259    16400    pessoas    TABLE     �   CREATE TABLE public.pessoas (
    cpf character varying NOT NULL,
    nome character varying NOT NULL,
    sexo character(1) NOT NULL
);
    DROP TABLE public.pessoas;
       public         heap    postgres    false                      0    16394    lances 
   TABLE DATA           :   COPY public.lances (cpf, pessoa, item, valor) FROM stdin;
    public          postgres    false    202   �                 0    16397    leiloes 
   TABLE DATA           ?   COPY public.leiloes (item, precoinicial, situacao) FROM stdin;
    public          postgres    false    203   �                 0    16400    pessoas 
   TABLE DATA           2   COPY public.pessoas (cpf, nome, sexo) FROM stdin;
    public          postgres    false    204   1       �
           2606    16410    lances Lances_pkey 
   CONSTRAINT     S   ALTER TABLE ONLY public.lances
    ADD CONSTRAINT "Lances_pkey" PRIMARY KEY (cpf);
 >   ALTER TABLE ONLY public.lances DROP CONSTRAINT "Lances_pkey";
       public            postgres    false    202            �
           2606    16436    leiloes Leiloes_pkey 
   CONSTRAINT     V   ALTER TABLE ONLY public.leiloes
    ADD CONSTRAINT "Leiloes_pkey" PRIMARY KEY (item);
 @   ALTER TABLE ONLY public.leiloes DROP CONSTRAINT "Leiloes_pkey";
       public            postgres    false    203            �
           2606    16455    pessoas Pessoas_pkey 
   CONSTRAINT     U   ALTER TABLE ONLY public.pessoas
    ADD CONSTRAINT "Pessoas_pkey" PRIMARY KEY (cpf);
 @   ALTER TABLE ONLY public.pessoas DROP CONSTRAINT "Pessoas_pkey";
       public            postgres    false    204                  x������ � �         %   x�;�9�4'���P�R�,8�\�B��b���� �D�         2   x�332131531��:�+'3_������"N_.C#�TN�R������ *�q     