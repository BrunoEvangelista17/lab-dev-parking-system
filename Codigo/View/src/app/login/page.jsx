"use client";
import { TextInput, Button, Box, Title } from "@mantine/core";
import { useState } from "react";
import { Link } from "react-router-dom"; // Adicionando a importação do Link

import styleLogin from './style.css';

export default function LoginPage() {
    const [formData, setFormData] = useState({
        username: "",
        password: "",
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
            <Title order={2}>Login</Title>
            <form onSubmit={handleSubmit}>
                <TextInput
                    label="Username"
                    placeholder="Seu nome de usuário"
                    name="username"
                    value={formData.username}
                    onChange={handleChange}
                    required
                />
                <TextInput
                    label="Password"
                    placeholder="Sua senha"
                    name="password"
                    type="password"
                    value={formData.password}
                    onChange={handleChange}
                    required
                />
                <Button type="submit" mt="md">
                    Entrar
                </Button>
            </form>
            <p>Não tem uma conta?
                <strong>
                    <Link to="/cadastro_cliente"> Registre-se</Link>
                </strong>
            </p>
        </Box>
    );
}