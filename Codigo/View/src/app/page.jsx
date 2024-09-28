'use client'
import React, { useState } from 'react';
import { MantineProvider, Button, Modal, Slider, Grid, Notification, Accordion, Text, Card } from '@mantine/core';
import { showNotification } from '@mantine/notifications';


function App() {
  // Estados para controlar o modal e o slider
  const [modalOpened, setModalOpened] = useState(false);
  const [sliderValue, setSliderValue] = useState(50);

  return (
    <MantineProvider withGlobalStyles withNormalizeCSS>
      <div style={{ padding: '2rem' }}>
        {/* Exemplo de Grid */}
        <Grid>
          <Grid.Col span={4}>
            <Card shadow="sm" padding="lg">
              <Text>Componente Card 1</Text>
            </Card>
          </Grid.Col>
          <Grid.Col span={4}>
            <Card shadow="sm" padding="lg">
              <Text>Componente Card 2</Text>
            </Card>
          </Grid.Col>
          <Grid.Col span={4}>
            <Card shadow="sm" padding="lg">
              <Text>Componente Card 3</Text>
            </Card>
          </Grid.Col>
        </Grid>

        {/* Componente Slider */}
        <div style={{ marginTop: '2rem' }}>
          <Text>Valor do Slider: {sliderValue}</Text>
          <Slider
            value={sliderValue}
            onChange={setSliderValue}
            label={(val) => `${val}%`}
            style={{ maxWidth: 300, margin: 'auto' }}
          />
        </div>

        {/* Botão para abrir o Modal */}
        <Button style={{ marginTop: '2rem' }} onClick={() => setModalOpened(true)}>
          Abrir Modal
        </Button>

        {/* Modal */}
        <Modal opened={modalOpened} onClose={() => setModalOpened(false)} title="Exemplo de Modal">
          <Text>Este é um exemplo simples de modal com conteúdo dentro.</Text>
        </Modal>

        {/* Componente Accordion */}
        <div style={{ marginTop: '2rem', maxWidth: 600, margin: 'auto' }}>
          <Accordion>
            <Accordion.Item label="Seção 1">
              <Text>Aqui está o conteúdo da seção 1.</Text>
            </Accordion.Item>
            <Accordion.Item label="Seção 2">
              <Text>Aqui está o conteúdo da seção 2.</Text>
            </Accordion.Item>
            <Accordion.Item label="Seção 3">
              <Text>Aqui está o conteúdo da seção 3.</Text>
            </Accordion.Item>
          </Accordion>
        </div>
      </div>
    </MantineProvider>
  );
}

export default App;
