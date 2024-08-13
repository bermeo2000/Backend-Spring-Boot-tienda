package com.example.Tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TiendaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiendaApplication.class, args);
    }

    /*
    @Bean
    CommandLineRunner init(UsuarioRepository userRepository) {
        return args -> {
            // Create PERMISSIONS
            PermissionEntity createPermission = PermissionEntity.builder()
                    .name("CREATE")
                    .build();

            PermissionEntity readPermission = PermissionEntity.builder()
                    .name("READ")
                    .build();

            PermissionEntity updatePermission = PermissionEntity.builder()
                    .name("UPDATE")
                    .build();

            PermissionEntity deletePermission = PermissionEntity.builder()
                    .name("DELETE")
                    .build();

            PermissionEntity refactorPermission = PermissionEntity.builder()
                    .name("REFACTOR")
                    .build();

            // Create ROLES
            Rol roleAdmin = Rol.builder()
                    .roleEnum(RoleEnum.ADMIN)
                    .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
                    .build();

            Rol roleUser = Rol.builder()
                    .roleEnum(RoleEnum.USER)
                    .permissionList(Set.of(createPermission, readPermission))
                    .build();

            Rol roleInvited = Rol.builder()
                    .roleEnum(RoleEnum.INVITED)
                    .permissionList(Set.of(readPermission))
                    .build();

            Rol roleDeveloper = Rol.builder()
                    .roleEnum(RoleEnum.DEVELOPER)
                    .permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
                    .build();

            // CREATE USERS
            Usuario userGema = Usuario.builder()
                    .username("Gema2000")
                    .nombre("Gema")
                    .apellido("Macias")
                    .cedula("321456890")
                    .telefono("098654123")
                    .imagen("gema.png")
                    .email("gema@gmail.com")
                    .password("gema2000")
                    .estado(true)
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleAdmin))
                    .build();

            Usuario userBermeo = Usuario.builder()
                    .username("Bermeo2000")
                    .nombre("Luis")
                    .apellido("Bermeo")
                    .cedula("432156890")
                    .telefono("098651234")
                    .imagen("bermeo.png")
                    .email("bermeo@gmail.com")
                    .password("bermeo2000")
                    .estado(true)
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleUser))
                    .build();

            Usuario userFiorella = Usuario.builder()
                    .username("Fiore2000")
                    .nombre("Fiorella")
                    .apellido("Muños")
                    .cedula("123456890")
                    .telefono("098654321")
                    .imagen("fiore.png")
                    .email("fiore@gmail.com")
                    .password("fiore2000")
                    .estado(true)
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleInvited))
                    .build();

            Usuario userAngi = Usuario.builder()
                    .username("Angi2000")
                    .nombre("angela")
                    .apellido("Bermeo")
                    .cedula("213456890")
                    .telefono("098654312")
                    .imagen("angi.png")
                    .email("angi@gmail.com")
                    .password("angi2000")
                    .estado(true)
                    .isEnabled(true)
                    .accountNoExpired(true)
                    .accountNoLocked(true)
                    .credentialNoExpired(true)
                    .roles(Set.of(roleDeveloper))
                    .build();

            userRepository.saveAll(List.of(userGema, userBermeo, userFiorella, userAngi));
        };
    }

     */
}

