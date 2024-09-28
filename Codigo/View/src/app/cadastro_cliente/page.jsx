"use client";
import { TextInput, Button, Box, Title } from "@mantine/core";
import { useState } from "react";

import styleClienteC from './style.css';

export default function cadastroCliente() {
    const [formData, setFormData] = useState({
        nome: "",
        rg: "",
        cpf: "",
        endereco: "",
        profissao: "",
        empregador: "",
    });

    const handleChange = (e) => {
        const { name, value } = e.target;
        setFormData({ ...formData, [name]: value });
    };

    const handleSubmit = (e) => {
        e.preventDefault();
        // Lógica para enviar os dados do formulário
        console.log(formData);
    };

    return (
        <Box className={"width_box_3"} mx="auto">
            <Title order={2}>Cadastro de Cliente</Title>
            <form onSubmit={handleSubmit}>
            <TextInput
                label="Nome"
                placeholder="Seu nome"
                name="nome"
                value={formData.nome}
                onChange={handleChange}
                required
            />
            <TextInput
                label="RG"
                placeholder="Seu RG"
                name="rg"
                value={formData.rg}
                onChange={handleChange}
                required
            />
            <TextInput
                label="CPF"
                placeholder="Seu CPF"
                name="cpf"
                value={formData.cpf}
                onChange={handleChange}
                required
            />
            <TextInput
                label="Endereço"
                placeholder="Seu endereço"
                name="endereco"
                value={formData.endereco}
                onChange={handleChange}
                required
            />
            <TextInput
                label="Profissão"
                placeholder="Sua profissão"
                name="profissao"
                value={formData.profissao}
                onChange={handleChange}
                required
            />
            <TextInput
                label="Empregador"
                placeholder="Seu empregador"
                name="empregador"
                value={formData.empregador}
                onChange={handleChange}
                required
            />
            <Button type="submit" mt="md">
                Cadastrar
            </Button>
            </form>
        </Box>
    );
}
