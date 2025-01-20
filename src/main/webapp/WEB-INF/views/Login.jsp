<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire de Connexion</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="/css/Login.css">

</head>
<body>

<div class="login-container">
    <h2>Connexion</h2>
    <form>
        <!-- Champ Email -->
        <div class="mb-3">
            <label for="email" class="form-label">Adresse Email</label>
            <input type="email" class="form-control" id="email" placeholder="Entrez votre email" required>
        </div>

        <!-- Champ Mot de Passe -->
        <div class="mb-3">
            <label for="password" class="form-label">Mot de Passe</label>
            <input type="password" class="form-control" id="password" placeholder="Entrez votre mot de passe" required>
        </div>

        <!-- Bouton de Connexion -->
        <button type="submit" class="btn btn-login">Se Connecter</button>

        <!-- Lien Mot de Passe Oublié -->
        <div class="forgot-password">
            <a href="#">Mot de passe oublié ?</a>
        </div>
    </form>
</div>

<!-- Bootstrap JS (optionnel, pour les fonctionnalités interactives) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>