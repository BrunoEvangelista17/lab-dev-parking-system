'use client'
import React, { useState } from 'react';
import { Card, Container, Title, TextInput, Button, Group, List, Text, NumberInput, Modal, Grid,  Badge} from '@mantine/core';

function ClienteProfile() {
  // Estado com os dados do cliente, incluindo investimentos já existentes
  const [cliente, setCliente] = useState({
    id: 1,
    nome: 'João Silva',
    rg: '123456789',
    cpf: '111.222.333-44',
    endereco: 'Rua das Flores, 123',
    profissao: 'Engenheiro',
    empregador: 'Empresa ABC',
    investimentos: [
      { nome: 'Investimento A', valor: 1000 },
      { nome: 'Investimento B', valor: 2000 },
    ],
  });

  const pedidos = [
    {
      id: 1,
      aprovado: true,
      descricao: 'Pedido de aluguel para viagem',
      valor: 5000,
      duration: 7,
      veiculo: 'Toyota Corolla',
      cliente: 'João Silva',
      agente: 'Empresa de Aluguel XYZ',
    },
    {
      id: 2,
      aprovado: false,
      descricao: 'Pedido para entrega de mercadorias',
      valor: 3000,
      duration: 3,
      veiculo: 'Honda Civic',
      cliente: 'Maria Oliveira',
      agente: 'Aluguel de Carros ABC',
    },
    {
      id: 3,
      aprovado: true,
      descricao: 'Pedido para transporte de funcionários',
      valor: 8000,
      duration: 10,
      veiculo: 'Ford Ranger',
      cliente: 'Carlos Pereira',
      agente: 'Locadora de Veículos 123',
    },
  ];



  // Estado de edição
  const [isEditing, setIsEditing] = useState(false);

  // Novo investimento
  const [novoInvestimento, setNovoInvestimento] = useState({ nome: '', valor: 0 });

  // Modal de edição de investimento
  const [opened, setOpened] = useState(false);
  const [editIndex, setEditIndex] = useState(null);
  const [editInvestimento, setEditInvestimento] = useState({ nome: '', valor: 0 });

  // Função para lidar com mudanças nos campos de texto do cliente
  const handleChange = (e) => {
    const { name, value } = e.target;
    setCliente((prevCliente) => ({
      ...prevCliente,
      [name]: value,
    }));
  };

  // Função para lidar com mudanças nos campos de investimento
  const handleInvestimentoChange = (e) => {
    const { name, value } = e.target;
    setNovoInvestimento((prevInvestimento) => ({
      ...prevInvestimento,
      [name]: value,
    }));
  };

  // Função para lidar com mudanças no valor do investimento
  const handleValorChange = (value) => {
    setNovoInvestimento((prevInvestimento) => ({
      ...prevInvestimento,
      valor: value,
    }));
  };

  // Função para salvar os dados
  const handleSave = () => {
    setIsEditing(false);
    console.log('Dados salvos:', cliente);
  };

  // Função para adicionar novo investimento
  const adicionarInvestimento = () => {
    if (novoInvestimento.nome.trim() !== '' && novoInvestimento.valor > 0) {
      setCliente((prevCliente) => ({
        ...prevCliente,
        investimentos: [...prevCliente.investimentos, { nome: novoInvestimento.nome, valor: novoInvestimento.valor }],
      }));
      setNovoInvestimento({ nome: '', valor: 0 }); // Limpa os campos de entrada
    }
  };

  // Função para abrir o modal e editar um investimento
  const openEditModal = (index) => {
    setEditIndex(index);
    setEditInvestimento(cliente.investimentos[index]);
    setOpened(true);
  };

  // Função para salvar a edição do investimento
  const saveEditedInvestimento = () => {
    const novosInvestimentos = [...cliente.investimentos];
    novosInvestimentos[editIndex] = editInvestimento;
    setCliente((prevCliente) => ({
      ...prevCliente,
      investimentos: novosInvestimentos,
    }));
    setOpened(false); // Fecha o modal após salvar
  };

  return (
    <Container>
      <Title order={1} align="center" mb="xl">
        Perfil do Cliente
      </Title>
      <Card shadow="sm" padding="lg" radius="md" withBorder>
        <Group position="apart" mb="sm">
          <Title order={2}>{cliente.nome}</Title>
          <Button onClick={() => setIsEditing(!isEditing)}>
            {isEditing ? 'Cancelar' : 'Editar'}
          </Button>
        </Group>

        <TextInput
          label="Nome"
          value={cliente.nome}
          name="nome"
          onChange={handleChange}
          disabled={!isEditing}
        />
        <TextInput
          label="RG"
          value={cliente.rg}
          name="rg"
          onChange={handleChange}
          disabled={!isEditing}
        />
        <TextInput
          label="CPF"
          value={cliente.cpf}
          name="cpf"
          onChange={handleChange}
          disabled={!isEditing}
        />
        <TextInput
          label="Endereço"
          value={cliente.endereco}
          name="endereco"
          onChange={handleChange}
          disabled={!isEditing}
        />
        <TextInput
          label="Profissão"
          value={cliente.profissao}
          name="profissao"
          onChange={handleChange}
          disabled={!isEditing}
        />
        <TextInput
          label="Empregador"
          value={cliente.empregador}
          name="empregador"
          onChange={handleChange}
          disabled={!isEditing}
        />

        {isEditing && (
          <Button fullWidth mt="md" onClick={handleSave}>
            Salvar
          </Button>
        )}

        {/* Área de Investimentos */}
        <Title order={3} mt="xl" mb="md">
          Investimentos Auferidos
        </Title>
        <TextInput
          label="Nome do investimento"
          placeholder="Digite o nome do investimento"
          value={novoInvestimento.nome}
          name="nome"
          onChange={handleInvestimentoChange}
        />
        <NumberInput
          label="Valor do investimento"
          placeholder="Digite o valor"
          value={novoInvestimento.valor}
          onChange={handleValorChange}
          min={0}
          precision={2}
          step={100}
        />
        <Button onClick={adicionarInvestimento} mt="md" fullWidth>
          Adicionar Investimento
        </Button>

        {cliente.investimentos.length > 0 && (
          <List spacing="xs" size="sm" mt="md" center>
            {cliente.investimentos.map((investimento, index) => (
              <List.Item key={index}>
                <Text>
                  <strong>Nome:</strong> {investimento.nome} | <strong>Valor:</strong> R$ {investimento.valor.toFixed(2)}
                  <Button onClick={() => openEditModal(index)} ml="md" size="xs">
                    Editar
                  </Button>
                </Text>
              </List.Item>
            ))}
          </List>
        )}
      </Card>

      {/* Modal para editar investimento */}
      <Modal opened={opened} onClose={() => setOpened(false)} title="Editar Investimento">
        <TextInput
          label="Nome do investimento"
          value={editInvestimento.nome}
          onChange={(e) =>
            setEditInvestimento((prev) => ({
              ...prev,
              nome: e.target.value,
            }))
          }
        />
        <NumberInput
          label="Valor do investimento"
          value={editInvestimento.valor}
          onChange={(value) =>
            setEditInvestimento((prev) => ({
              ...prev,
              valor: value,
            }))
          }
          min={0}
          precision={2}
          step={100}
        />
        <Button onClick={saveEditedInvestimento} mt="md" fullWidth>
          Salvar Alterações
        </Button>
      </Modal>
      <Title order={1} align="center" mb="xl">
        Pedidos de Aluguel
      </Title>
      <Grid>
        {pedidos.map((pedido) => (
          <Grid.Col key={pedido.id} sm={6} md={4}>
            <Card shadow="sm" padding="lg" radius="md" withBorder>
              <Group position="apart" mb="md">
                <Title order={4}>Pedido #{pedido.id}</Title>
                <Badge color={pedido.aprovado ? 'green' : 'red'}>
                  {pedido.aprovado ? 'Aprovado' : 'Pendente'}
                </Badge>
              </Group>

              <Text><strong>Descrição:</strong> {pedido.descricao}</Text>
              <Text><strong>Valor:</strong> R$ {pedido.valor.toFixed(2)}</Text>
              <Text><strong>Duração:</strong> {pedido.duration} dias</Text>
              <Text><strong>Veículo:</strong> {pedido.veiculo}</Text>
              <Text><strong>Cliente:</strong> {pedido.cliente}</Text>
              <Text><strong>Empresa (Agente):</strong> {pedido.agente}</Text>

              <Button variant="light" fullWidth mt="md" radius="md">
                Ver Detalhes
              </Button>
            </Card>
          </Grid.Col>
        ))}
      </Grid>
    </Container>
  );
}

export default ClienteProfile;
