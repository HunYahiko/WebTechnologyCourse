const reviewController = require('../controllers/review');
const express = require('express');
const router = express.Router();

router.get('/', reviewController.findAll);

router.get('/:email', reviewController.findByEmail);

router.post('/', reviewController.create);

router.put('/:id', reviewController.update);

router.delete('/:id', reviewController.delete);

module.exports = router;


