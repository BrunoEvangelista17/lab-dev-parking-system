import Link from 'next/link';
import { Container, Group, Button, MantineProvider } from '@mantine/core';

const Header = () => {
  return (

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
  );
};

export default Header;
