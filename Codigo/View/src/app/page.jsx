'use client'
import React, { useState } from 'react';
import { MantineProvider, Button, Modal, Slider, Grid, Notification, Accordion, Text, Card } from '@mantine/core';
import { showNotification } from '@mantine/notifications';
import ClientePage from './perfil_vliente/page';

function App() {
  // Estados para controlar o modal e o slider
  const [modalOpened, setModalOpened] = useState(false);
  const [sliderValue, setSliderValue] = useState(50);

  return (
    <MantineProvider withGlobalStyles withNormalizeCSS>
      <ClientePage />
    </MantineProvider>
  );
}

export default App;
