'use client'

import React from 'react';
import { AppShell, MantineProvider} from '@mantine/core';
import Header from './header';

const Layout = ({ children }) => {
    const [open, setOpened] = React.useState(false);
  return (
    <>
    <MantineProvider>
    <AppShell
      header={{ height: 80 }}
      navbar={{ width: 300, breakpoint: 'sm' }}
      padding="md"
      footer={{ height: 50 }}
    >



      <AppShell.Main pl={16}>
      <Container>
      <Group position="center" spacing="xl">
        <Link href="/perfil_cliente">
          <Button variant="light">Perfil do Cliente</Button>
        </Link>
        <Link href="/catalogo_cliente">
          <Button variant="light">Catálogo de Veículos</Button>
        </Link>
        <Link href="/cadastro_cliente">
          <Button variant="light">Cadastro de Cliente</Button>
        </Link>
      </Group>
    </Container>
        <main>{children}</main>
      </AppShell.Main>
    </AppShell>
    </MantineProvider>
    </>
    
  );
};

export default Layout;