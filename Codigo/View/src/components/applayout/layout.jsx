'use client'

import React from 'react';
import { AppShell } from '@mantine/core';



const Layout = ({ children }) => {
    const [open, setOpened] = React.useState(false);
  return (
    <AppShell
      header={{ height: 80 }}
      navbar={{ width: 300, breakpoint: 'sm'}}
      padding="md"
      footer={{ height: 50 }}
    >



      <AppShell.Main pl={16}>
        <main>{children}</main>
      </AppShell.Main>
    </AppShell>
  );
};

export default Layout;