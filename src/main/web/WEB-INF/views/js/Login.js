        const loginBtn = document.getElementById('loginBtn');
        const loginPopup = document.getElementById('loginPopup');
        const closeLoginPopup = document.getElementById('closeLoginPopup');
        const loginForm = document.getElementById('loginForm');
        const switchToSignup = document.getElementById('switchToSignup');

        // Signup Popup
        const signupBtn = document.getElementById('signupBtn');
        const signupPopup = document.getElementById('signupPopup');
        const closeSignupPopup = document.getElementById('closeSignupPopup');
        const signupForm = document.getElementById('signupForm');
        const switchToLogin = document.getElementById('switchToLogin');

            // Function to open a popup
        function openPopup(popup) {
            popup.style.display = 'flex'; // Make the popup visible
            setTimeout(() => {
                popup.classList.add('show'); // Add the class for animation
            }, 10); // Delay to ensure display change is processed
        }

        // Function to close a popup
        function closePopup(popup) {
            popup.classList.remove('show'); // Remove the class for animation
            setTimeout(() => {
                popup.style.display = 'none'; // Hide the popup after animation
            }, 300); // Match CSS transition duration
        }

        // Open Login Popup
        loginBtn.addEventListener('click', () => {
            openPopup(loginPopup);
        });

        // Close Login Popup
        closeLoginPopup.addEventListener('click', () => {
            closePopup(loginPopup);
        });


        // Open Signup Popup
        signupBtn.addEventListener('click', () => {
            openPopup(signupPopup);
        });

        // Close Signup Popup
        closeSignupPopup.addEventListener('click', () => {
            closePopup(signupPopup);
        });

       