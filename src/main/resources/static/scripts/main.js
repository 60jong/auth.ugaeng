async function submitForm(event, formClass) {
  event.preventDefault();

  const form = document.querySelector(`.${formClass}`);
  const formData = new FormData(form);

  const jsonObject = {};
  formData.forEach((value, key) => {
    jsonObject[key] = value;
  });

  let url = '';
  if (formClass === 'signin-form') {
    url = '/api/signin';
  } else if (formClass === 'signup-form') {
    url = '/api/signup';
  }

  let redirect_url = 'http://3.38.241.100';

  try {
    const response = await fetch(url, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(jsonObject)
    });

    if (!response.ok) {
      alert('Failed to process');
    }
  } catch (error) {
    alert('Failed to process');
  } finally {
    window.location.href = redirect_url;
  }
}