'use client'
import React, { useState } from 'react';
import { Container, Grid, Card, Text, Title, Group, Button, Modal, NumberInput } from '@mantine/core';

// Dados estáticos simulando os veículos
const veiculos = [
  {
    id: 1,
    matricula: 'A12345',
    modelo: 'Toyota Corolla',
    placa: 'ABC-1234',
    ano: '2020',
    marca: 'Toyota',
  },
  {
    id: 2,
    matricula: 'B67890',
    modelo: 'Honda Civic',
    placa: 'DEF-5678',
    ano: '2019',
    marca: 'Honda',
  },
  {
    id: 3,
    matricula: 'C34567',
    modelo: 'Ford Ranger',
    placa: 'GHI-9012',
    ano: '2021',
    marca: 'Ford',
  },
  {
    id: 4,
    matricula: 'D89012',
    modelo: 'Chevrolet Onix',
    placa: 'JKL-3456',
    ano: '2022',
    marca: 'Chevrolet',
  },
  {
    id: 5,
    matricula: 'E54321',
    modelo: 'Volkswagen Golf',
    placa: 'MNO-7890',
    ano: '2021',
    marca: 'Volkswagen',
  },
  {
    id: 6,
    matricula: 'F23456',
    modelo: 'Hyundai Tucson',
    placa: 'PQR-1234',
    ano: '2020',
    marca: 'Hyundai',
  },
  {
    id: 7,
    matricula: 'G67890',
    modelo: 'BMW X5',
    placa: 'STU-5678',
    ano: '2022',
    marca: 'BMW',
  },
  {
    id: 8,
    matricula: 'H11223',
    modelo: 'Mercedes-Benz GLC',
    placa: 'VWX-9012',
    ano: '2022',
    marca: 'Mercedes-Benz',
  },
];

function CatalogoVeiculos() {
  // Estado para controlar o modal
  const [opened, setOpened] = useState(false);
  const [selectedVeiculo, setSelectedVeiculo] = useState(null);
  const [valorAluguel, setValorAluguel] = useState(0);
  const [diasAluguel, setDiasAluguel] = useState(1);

  // Função para abrir o modal e setar o veículo selecionado
  const handleAlugarVeiculo = (veiculo) => {
    setSelectedVeiculo(veiculo);
    setOpened(true);
  };

  // Função para fechar o modal
  const handleFecharModal = () => {
    setOpened(false);
    setSelectedVeiculo(null);
    setValorAluguel(0);
    setDiasAluguel(1);
  };

  return (
    <Container>
      <Title order={1} align="center" mb="xl">
        Catálogo de Veículos para Aluguel
      </Title>

      {/* Modal para exibir o resumo do aluguel */}
      <Modal
        opened={opened}
        onClose={handleFecharModal}
        title="Resumo do Aluguel"
      >
        {selectedVeiculo && (
          <>
            <Text><strong>Modelo:</strong> {selectedVeiculo.modelo}</Text>
            <Text><strong>Marca:</strong> {selectedVeiculo.marca}</Text>
            <Text><strong>Ano:</strong> {selectedVeiculo.ano}</Text>
            <Text><strong>Placa:</strong> {selectedVeiculo.placa}</Text>
            <Text><strong>Matrícula:</strong> {selectedVeiculo.matricula}</Text>

            <NumberInput
              label="Valor do Aluguel (R$)"
              placeholder="Insira o valor"
              value={valorAluguel}
              onChange={(value) => setValorAluguel(value)}
              min={0}
              mt="md"
              precision={2}
            />

            <NumberInput
              label="Dias de Aluguel"
              value={diasAluguel}
              onChange={(value) => setDiasAluguel(value)}
              min={1}
              mt="md"
            />

            <Button variant="outline" fullWidth mt="md" onClick={handleFecharModal}>
              Confirmar Aluguel
            </Button>
          </>
        )}
      </Modal>

      <Grid>
        {veiculos.map((veiculo) => (
          <Grid.Col key={veiculo.id} sm={6} md={3}>
            <Card shadow="sm" padding="lg" radius="md" withBorder>
              <Group position="apart" mb="md">
                <Title order={4}>{veiculo.modelo}</Title>
              </Group>

              <Text><strong>Marca:</strong> {veiculo.marca}</Text>
              <Text><strong>Ano:</strong> {veiculo.ano}</Text>
              <Text><strong>Placa:</strong> {veiculo.placa}</Text>
              <Text><strong>Matrícula:</strong> {veiculo.matricula}</Text>

              <Button
                variant="light"
                fullWidth
                mt="md"
                radius="md"
                onClick={() => handleAlugarVeiculo(veiculo)}
              >
                Alugar Veículo
              </Button>
            </Card>
          </Grid.Col>
        ))}
      </Grid>
    </Container>
  );
}

export default CatalogoVeiculos;
