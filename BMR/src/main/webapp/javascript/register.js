function openModal(message) {
    document.getElementById('modalMessage').innerHTML = message;
    document.getElementById('customModal').style.display = 'block';
 }

 function closeModal() {
    document.getElementById('customModal').style.display = 'none';
 }

 const searchParams = new URLSearchParams(location.search);
 const missElement = document.getElementById('miss');
 const misssElement = document.getElementById('misss');
 if (searchParams.has('miss')) {
    missElement.style.display = 'block';
    openModal('メールアドレスが無効です。');
 } else {
    missElement.style.display = 'none';
 }
 if (searchParams.has('miss')) {
    misssElement.style.display = 'block';
    openModal('パスワードが無効です。');
 } else {
    misssElement.style.display = 'none';
 }