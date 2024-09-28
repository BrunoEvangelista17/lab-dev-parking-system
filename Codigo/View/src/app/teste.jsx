'use client'
import React, { useState } from 'react';
import { MantineProvider, Button, TextInput, Card, Text } from '@mantine/core';

function mantineTest() {
  const [inputValue, setInputValue] = useState('');
  
  const handleButtonClick = () => {
    alert(`Você digitou: ${inputValue}`);
  };

  return (
    <MantineProvider withGlobalStyles withNormalizeCSS>
      <div style={{ maxWidth: 400, margin: 'auto', padding: '2rem' }}>
        {/* Componente Card para agrupar o conteúdo */}
        <Card shadow="sm" padding="lg" withBorder>
          <Text size="lg" weight={500} style={{ marginBottom: '1rem' }}>
            Exemplo de Formulário
          </Text>
          
          {/* Componente TextInput para o campo de texto */}
          <TextInput
            label="Digite algo"
            placeholder="Seu texto"
            value={inputValue}
            onChange={(event) => setInputValue(event.currentTarget.value)}
            style={{ marginBottom: '1rem' }}
          />
          
          {/* Componente Button para ação */}
          <Button variant="filled" color="blue" onClick={handleButtonClick}>
            Enviar
          </Button>
        </Card>
      </div>
    </MantineProvider>
  );
}

export default mantineTest;
