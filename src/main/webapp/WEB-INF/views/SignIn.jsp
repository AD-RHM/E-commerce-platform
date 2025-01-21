<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="/css/SignIn.css">
</head>
<body>

<div class="signup-container">
    <h2>Inscription</h2>
    <form action="/signup" method="POST" enctype="multipart/form-data">
        <!-- Champ Prénom -->
        <div class="mb-3">
            <label for="firstName" class="form-label">Prénom</label>
            <input type="text" class="form-control" id="firstName" name="firstName"  required>
        </div>

        <!-- Champ Nom -->
        <div class="mb-3">
            <label for="lastName" class="form-label">Nom</label>
            <input type="text" class="form-control" id="lastName" name="lastName" required>
        </div>

        <!-- Champ Email -->
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" class="form-control" id="email" name="email"  required>
        </div>

        <!-- Champ Mot de Passe -->
        <div class="mb-3">
            <label for="password" class="form-label">Mot de Passe</label>
            <input type="password" class="form-control" id="password" name="password"  required>
        </div>

        <!-- Champ Rôle -->
        <div class="mb-3">
            <label for="role" class="form-label">Rôle</label>
            <select class="form-control" id="role" name="role" required>
                <option value="USER">Vendeur</option>
                <option value="ADMIN">Achteur</option>
            </select>
        </div>

        <!-- Champ Numéro de Téléphone -->
        <div class="mb-3">
            <label for="phoneNumber" class="form-label">Numéro de Téléphone</label>
            <input type="tel" class="form-control" id="phoneNumber" name="phoneNumber" required>
        </div>

        <!-- Champ Adresse -->
        <div class="mb-3">
            <label for="address" class="form-label">Adresse</label>
            <input type="text" class="form-control" id="address" name="address">
        </div>

        <!-- Champ Ville -->
        <div class="mb-3">
            <label for="city" class="form-label">Ville</label>
            <input type="text" class="form-control" id="city" name="city" >
        </div>

        <!-- Champ Image (Upload) -->
        <div class="mb-3">
            <label for="image" class="form-label">Image de Profil</label>
            <input type="file" class="form-control" id="image" name="image" accept="image/*">
        </div>

        <!-- Bouton d'Inscription -->
        <button type="submit" class="btn btn-signup">S'inscrire</button>
    </form>
</div>

<!-- Bootstrap JS (optionnel, pour les fonctionnalités interactives) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>